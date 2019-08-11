package com.yizhiquan.stockadmin.stockadmin.service.impl;

import com.yizhiquan.stockadmin.stockadmin.dao.ProductMapper;
import com.yizhiquan.stockadmin.stockadmin.dao.ProductSpecMapper;
import com.yizhiquan.stockadmin.stockadmin.dao.ProductWarehouseStockMapper;
import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;
import com.yizhiquan.stockadmin.stockadmin.domain.ProductWarehouseStock;
import com.yizhiquan.stockadmin.stockadmin.domain.dto.TransferReq;
import com.yizhiquan.stockadmin.stockadmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;

    private ProductSpecMapper productSpecMapper;

    private ProductWarehouseStockMapper productWarehouseStockMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper,
                              ProductSpecMapper productSpecMapper,
                              ProductWarehouseStockMapper productWarehouseStockMapper){
        this.productMapper=productMapper;
        this.productSpecMapper=productSpecMapper;
        this.productWarehouseStockMapper=productWarehouseStockMapper;
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Product saveProduct(Product product) {
        if(product.getId()!=null){
            productMapper.updateMainProduct(product);
        }else{
            productMapper.insertSelective(product);
        }
        return product;
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ProductSpec saveProductSpec(ProductSpec productSpec) {
        ProductSpec existProductSpec=productSpecMapper.selectExistProductSpec(productSpec);
        //todo 保存采购日志
        if(existProductSpec==null){
            productSpecMapper.insertSelective(productSpec);

        }else{
            //如果存在ProductSpec,并且是来自修改数量操作
            if(productSpec.getId()!=null){
                existProductSpec.setQuantity(productSpec.getQuantity());
            }else{
                // 属于新录入商品数量，在原来的商品数量上进行累加
                existProductSpec.setQuantity(productSpec.getQuantity()+existProductSpec.getQuantity());
            }
            existProductSpec.setPurchaseTime(productSpec.getPurchaseTime());
            productSpecMapper.updateProductSpec(existProductSpec);
            productSpec=existProductSpec;
        }
        saveProductStock(productSpec);
        return productSpec;
    }

    private void saveProductStock(ProductSpec productSpec){
        ProductWarehouseStock warehouseStock = ProductWarehouseStock.builder()
                .productId(productSpec.getProductId())
                .productSpecId(productSpec.getId())
                .warehouseId(productSpec.getWarehouseId())
                .quantity(productSpec.getQuantity())
                .warehouseName(productSpec.getWarehouseName())
                .brandName(productSpec.getBrandName())
                .build();
        ProductWarehouseStock stock=productWarehouseStockMapper.selectBySpecAndProduct(warehouseStock);
        if(stock!=null){
            //更新
            stock.setQuantity(stock.getQuantity()+warehouseStock.getQuantity());
            productWarehouseStockMapper.updateProductStock(stock);
        }
        //插入
        productWarehouseStockMapper.insert(warehouseStock);
    }

    @Override
    public Product selectProductByCode(String productCode) {
        List<Product> productList= productMapper.selectProductByCode(productCode);
        return CollectionUtils.isEmpty(productList) ? null:productList.get(0);
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void saveTransferProduct(List<TransferReq> transferReqList) {
        // 获取到所有的原来调拨商品
        Set<Integer> stockSet = transferReqList.stream().filter(transferReq -> transferReq.getStockId() != null).map(TransferReq::getStockId).collect(Collectors.toSet());
        List<ProductWarehouseStock> stockList=productWarehouseStockMapper.selectStockByIds(stockSet);
        Map<Integer, ProductWarehouseStock> stockMap = stockList.stream().collect(Collectors.toMap(ProductWarehouseStock::getId, productWarehouseStock -> {
            productWarehouseStock.setQuantity(0);
            return productWarehouseStock;
        }));
        //处理调拨
        for(TransferReq transferReq:transferReqList){
            //保存或更新
            //如果数据库中存在相同的 商品型号，存储仓库，则就更新
            ProductWarehouseStock findParam = ProductWarehouseStock.builder().productId(transferReq.getProductId())
                    .productSpecId(transferReq.getSpecId())
                    .warehouseId(transferReq.getWarehouseId())
                    .quantity(transferReq.getQuantity())
                    .warehouseName(transferReq.getWarehouseName())
                    .brandName(transferReq.getBrandName())
                    .build();
            ProductWarehouseStock productWarehouseStock = productWarehouseStockMapper.selectBySpecAndProduct(findParam);
            //ProductWarehouseStock orginalStock = stockMap.get(transferReq.getStockId());
            ProductWarehouseStock orginalStock =productWarehouseStockMapper.selectStockById(transferReq.getStockId());
            //调拨的数量
            orginalStock.setQuantity(orginalStock.getQuantity()-transferReq.getQuantity());
            if(productWarehouseStock==null){
                //保存

                productWarehouseStockMapper.insert(findParam);
                productWarehouseStockMapper.updateProductStock(orginalStock);
            }else{
                //存在则就更新
                findParam.setQuantity(productWarehouseStock.getQuantity()+transferReq.getQuantity());
                //更新
                productWarehouseStockMapper.updateProductStock(findParam);
                productWarehouseStockMapper.updateProductStock(orginalStock);

            }
        }
    }

    @Override
    public List<Product> findProductWarehouseByProductCode(String productCode) {
        return productMapper.selectProductStock(productCode);
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void deleteProductSpec(Integer id) {
        productSpecMapper.deleteProductSpec(id);
    }

    @Override
    public ProductSpec getProductSpecById(Integer id) {
        return productSpecMapper.getProductSpecById(id);
    }
}

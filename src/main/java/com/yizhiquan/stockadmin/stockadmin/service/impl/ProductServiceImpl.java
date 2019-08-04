package com.yizhiquan.stockadmin.stockadmin.service.impl;

import com.yizhiquan.stockadmin.stockadmin.dao.ProductMapper;
import com.yizhiquan.stockadmin.stockadmin.dao.ProductSpecMapper;
import com.yizhiquan.stockadmin.stockadmin.dao.ProductWarehouseStockMapper;
import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;
import com.yizhiquan.stockadmin.stockadmin.domain.dto.TransferReq;
import com.yizhiquan.stockadmin.stockadmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
            return productSpec;
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
            return existProductSpec;
        }

    }

    @Override
    public Product selectProductByCode(String productCode) {
        List<Product> productList= productMapper.selectProductByCode(productCode);
        return CollectionUtils.isEmpty(productList) ? null:productList.get(0);
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void saveTransferProduct(List<TransferReq> transferReqList) {
        //调拨记录插入
        List<TransferReq> newTransferList=new ArrayList<>();
        List<TransferReq> existTransferList=new ArrayList<>();
        for (TransferReq transferReq: transferReqList) {
            if(transferReq.getStockId()==null){
                //数据插入
                newTransferList.add(transferReq);
            }else{
                existTransferList.add(transferReq);
            }
        }
        if(!CollectionUtils.isEmpty(newTransferList)){
            productWarehouseStockMapper.batchInsert(transferReqList);
        }
        if(!CollectionUtils.isEmpty(existTransferList)){
            productWarehouseStockMapper.batchUpdate(existTransferList);
        }
        //商品调拨商品数量修改
        //productWarehouseStockMapper.batchInsert(transferReqList);

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

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
        productMapper.insertSelective(product);
        return product;
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void saveProductSpec(ProductSpec productSpec) {
        // TODO: 2019/6/22 先检验一遍商品信息，是否存在

        //Step2 添加商品规格熟悉到商品中，如果存在，不能消减商品数量

        productSpecMapper.insertSelective(productSpec);
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
}

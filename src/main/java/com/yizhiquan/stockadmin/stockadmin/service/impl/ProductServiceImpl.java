package com.yizhiquan.stockadmin.stockadmin.service.impl;

import com.yizhiquan.stockadmin.stockadmin.dao.ProductMapper;
import com.yizhiquan.stockadmin.stockadmin.dao.ProductSpecMapper;
import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;
import com.yizhiquan.stockadmin.stockadmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;

    private ProductSpecMapper productSpecMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper,ProductSpecMapper productSpecMapper){
        this.productMapper=productMapper;
        this.productSpecMapper=productSpecMapper;
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
        Product product= productMapper.selectProductByCode(productCode);
        return product;
    }
}

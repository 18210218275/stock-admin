package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;

import java.util.List;

public interface ProductSpecMapper {
    int insert(ProductSpec record);

    int insertSelective(ProductSpec record);

    List<ProductSpec> selectProductBySpec(ProductSpec productSpecParam);

    void updateProductStock(ProductSpec productSpecParam);
}
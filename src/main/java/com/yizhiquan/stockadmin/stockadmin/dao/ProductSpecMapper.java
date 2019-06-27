package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;

public interface ProductSpecMapper {
    int insert(ProductSpec record);

    int insertSelective(ProductSpec record);
}
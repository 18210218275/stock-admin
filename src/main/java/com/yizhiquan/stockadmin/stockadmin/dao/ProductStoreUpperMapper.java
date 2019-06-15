package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.ProductStoreUpper;

public interface ProductStoreUpperMapper {
    int insert(ProductStoreUpper record);

    int insertSelective(ProductStoreUpper record);
}
package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.Product;

public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);
}
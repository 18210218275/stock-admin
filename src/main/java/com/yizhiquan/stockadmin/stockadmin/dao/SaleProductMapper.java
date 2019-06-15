package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.SaleProduct;

public interface SaleProductMapper {
    int insert(SaleProduct record);

    int insertSelective(SaleProduct record);
}
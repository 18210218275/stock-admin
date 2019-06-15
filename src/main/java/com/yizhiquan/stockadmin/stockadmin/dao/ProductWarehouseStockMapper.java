package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.ProductWarehouseStock;

public interface ProductWarehouseStockMapper {
    int insert(ProductWarehouseStock record);

    int insertSelective(ProductWarehouseStock record);
}
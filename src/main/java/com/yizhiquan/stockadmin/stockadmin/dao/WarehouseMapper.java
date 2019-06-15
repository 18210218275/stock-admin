package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.Warehouse;

public interface WarehouseMapper {
    int insert(Warehouse record);

    int insertSelective(Warehouse record);
}
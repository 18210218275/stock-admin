package com.yizhiquan.stockadmin.stockadmin.dao;

import com.github.pagehelper.Page;
import com.yizhiquan.stockadmin.stockadmin.domain.Warehouse;
import org.apache.ibatis.annotations.Param;

public interface WarehouseMapper {
    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Page<Warehouse> selectWarehouse();

    void deleteWarehouse(@Param("id") Integer id);

    Warehouse selectWarehouseById(@Param("id") Integer id);

    void updateWarehouse(Warehouse warehouse);
}
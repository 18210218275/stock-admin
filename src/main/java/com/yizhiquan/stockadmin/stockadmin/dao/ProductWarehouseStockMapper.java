package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.ProductWarehouseStock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductWarehouseStockMapper {
    int insert(ProductWarehouseStock record);

    int insertSelective(ProductWarehouseStock record);
}
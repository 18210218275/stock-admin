package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.SaleProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SaleProductMapper {
    int insert(SaleProduct record);

    int insertSelective(SaleProduct record);
}
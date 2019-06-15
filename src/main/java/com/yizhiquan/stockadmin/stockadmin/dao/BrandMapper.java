package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.Brand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandMapper {
    int insert(Brand record);

    int insertSelective(Brand record);
}
package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.ProductStoreUpper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductStoreUpperMapper {
    int insert(ProductStoreUpper record);

    int insertSelective(ProductStoreUpper record);
}
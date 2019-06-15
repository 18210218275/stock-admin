package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);
}
package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);

    Product selectProductByCode(@Param("productCode") String productCode);

    Product selectProductSpecByCode(String productCode);
}
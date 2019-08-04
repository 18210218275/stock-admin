package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectProductByCode(@Param("productCode") String productCode);

    List<Product> selectProductStock(@Param("productCode") String productCode);


    void updateMainProduct(Product product);


}
package com.yizhiquan.stockadmin.stockadmin.dao;

import com.github.pagehelper.Page;
import com.yizhiquan.stockadmin.stockadmin.domain.SaleProduct;
import org.apache.ibatis.annotations.Param;

public interface SaleProductMapper {
    int insert(SaleProduct record);

    int insertSelective(SaleProduct record);

    Page<SaleProduct> selectSaleProduct();


    void deleteSaleProduct(@Param("id") Integer id);

    SaleProduct selectSaleProductById(@Param("id") Integer id);
}
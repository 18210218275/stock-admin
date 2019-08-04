package com.yizhiquan.stockadmin.stockadmin.dao;

import com.github.pagehelper.Page;
import com.yizhiquan.stockadmin.stockadmin.domain.SaleProduct;

import java.util.List;

public interface SaleProductMapper {
    int insert(SaleProduct record);

    int insertSelective(SaleProduct record);

    Page<SaleProduct> selectSaleProduct();


}
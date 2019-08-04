package com.yizhiquan.stockadmin.stockadmin.service;

import com.github.pagehelper.Page;
import com.yizhiquan.stockadmin.stockadmin.domain.SaleProduct;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.SaleProductVo;


public interface SaleProductService {
    void saveSaleProduct(SaleProductVo saleProduct) throws Exception;

    Page<SaleProduct> findListPage(int pageNum, int pageSize);

    void deleteSaleProduct(Integer id);

    SaleProduct selectSaleById(Integer id);
}

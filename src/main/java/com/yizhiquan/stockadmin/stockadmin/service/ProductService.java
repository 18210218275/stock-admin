package com.yizhiquan.stockadmin.stockadmin.service;

import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;

public interface ProductService {
    /**
     * 添加商品主体信息
     * @param product
     */
    Product saveProduct(Product product);

    /**
     * 录入商品规格属性等详细信息
     * @param productSpec
     */
    void saveProductSpec(ProductSpec productSpec);

    /**
     * 通过商品编号查询出商品相关信息
     * @param productCode
     * @return
     */
    Product selectProductByCode(String productCode);
}

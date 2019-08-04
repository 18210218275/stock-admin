package com.yizhiquan.stockadmin.stockadmin.service;

import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;
import com.yizhiquan.stockadmin.stockadmin.domain.dto.TransferReq;

import java.util.List;

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
    ProductSpec saveProductSpec(ProductSpec productSpec);

    /**
     * 通过商品编号查询出商品相关信息
     * @param productCode
     * @return
     */
    Product selectProductByCode(String productCode);

    /**
     * 保存调拨商品
     * @param transferReqList
     */
    void saveTransferProduct(List<TransferReq> transferReqList);

    /**
     * 调拨商品查询
     * @param productCode
     * @return
     */
    List<Product> findProductWarehouseByProductCode(String productCode);

    /**
     * 删除ProductSpec
     * @param id
     */
    void deleteProductSpec(Integer id);

    /**
     * 获取到商品ProductSpec详细信息
     * @param id
     * @return
     */
    ProductSpec getProductSpecById(Integer id);
}

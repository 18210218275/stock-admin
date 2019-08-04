package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductSpecMapper {
    int insert(ProductSpec record);

    int insertSelective(ProductSpec record);

    List<ProductSpec> selectProductBySpec(ProductSpec productSpecParam);

    void updateProductStock(ProductSpec productSpecParam);

    void deleteProductSpec(@Param("id") Integer id);

    ProductSpec selectExistProductSpec(ProductSpec productSpec);

    void updateProductSpec(ProductSpec existProductSpec);

    ProductSpec getProductSpecById(Integer id);
}
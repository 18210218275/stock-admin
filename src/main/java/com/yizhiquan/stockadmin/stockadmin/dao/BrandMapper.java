package com.yizhiquan.stockadmin.stockadmin.dao;

import com.github.pagehelper.Page;
import com.yizhiquan.stockadmin.stockadmin.domain.Brand;

public interface BrandMapper {
    int insert(Brand record);

    int insertSelective(Brand record);

    Page<Brand> selectBrand();

    void deleteBrand(Integer id);

    Brand getBrandById(Integer id);

    void updateBrand(Brand brand);
}
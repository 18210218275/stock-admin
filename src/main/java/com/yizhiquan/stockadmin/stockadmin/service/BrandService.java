package com.yizhiquan.stockadmin.stockadmin.service;

import com.yizhiquan.stockadmin.stockadmin.domain.Brand;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.PageData;

import java.util.List;

public interface BrandService {
    void saveBrand(Brand brand);
    /**
     * 分页查询品牌数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageData<Brand> findlList(int pageNum, int pageSize);

    /**
     * 查询所有品牌品类，通过缓存
     * @return
     */
    List<Brand> findAllBrand();
}

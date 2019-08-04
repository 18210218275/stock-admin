package com.yizhiquan.stockadmin.stockadmin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yizhiquan.stockadmin.stockadmin.dao.BrandMapper;
import com.yizhiquan.stockadmin.stockadmin.domain.Brand;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.PageData;
import com.yizhiquan.stockadmin.stockadmin.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class BrandServiceImpl implements BrandService {
    private BrandMapper brandMapper;

    @Autowired
    public BrandServiceImpl(BrandMapper brandMapper){
        this.brandMapper=brandMapper;
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void saveBrand(Brand brand) {
        if(brand.getId()!=null){
            brandMapper.updateBrand(brand);
        }else{
            brandMapper.insertSelective(brand);
        }

    }

    @Override
    public PageData<Brand> findlList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Brand> brandList=brandMapper.selectBrand();
        PageData<Brand> brandPageData = PageData.<Brand>builder()
                .pageNum(pageNum)
                .pageSize(pageSize)
                .totalNum(brandList.getTotal())
                .totalPage(brandList.getPages())
                .data(brandList.getResult())
                .build();
        return brandPageData;
    }

    @Override
    public List<Brand> findAllBrand() {
        //定义缓存 guava cache
        return brandMapper.selectBrand();
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void deleteBrand(Integer id) {
        brandMapper.deleteBrand(id);
    }

    @Override
    public Brand getBrandById(Integer id) {
        return brandMapper.getBrandById(id);
    }
}

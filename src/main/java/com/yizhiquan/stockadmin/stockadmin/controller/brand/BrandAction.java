package com.yizhiquan.stockadmin.stockadmin.controller.brand;

import com.alibaba.fastjson.JSON;
import com.yizhiquan.stockadmin.stockadmin.common.constant.PageEnum;
import com.yizhiquan.stockadmin.stockadmin.domain.Brand;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.PageData;
import com.yizhiquan.stockadmin.stockadmin.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("brand")
public class BrandAction {
    private BrandService brandService;

    @Autowired
    public BrandAction(BrandService brandService){
        this.brandService=brandService;
    }


    @GetMapping("/list")
    public ModelAndView listBrand(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageMenuName", PageEnum.BRAND_LIST_PAGE.getPageCode());
        modelAndView.setViewName("brand/brand_list");
        return modelAndView;
    }

    @PostMapping("/saveBrand")
    @ResponseBody
    public String saveBrand(Brand brand){
        brandService.saveBrand(brand);
        return JSON.toJSONString(brand);
    }

    @GetMapping("/findList")
    @ResponseBody
    public String findList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        PageData<Brand> brandPageList=brandService.findlList(pageNum,pageSize);
        return JSON.toJSONString(brandPageList);
    }
}

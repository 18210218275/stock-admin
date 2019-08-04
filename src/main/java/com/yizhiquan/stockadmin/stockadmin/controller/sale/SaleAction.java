package com.yizhiquan.stockadmin.stockadmin.controller.sale;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.yizhiquan.stockadmin.stockadmin.common.constant.PageEnum;
import com.yizhiquan.stockadmin.stockadmin.common.exception.ResultWrapper;
import com.yizhiquan.stockadmin.stockadmin.common.exception.ServiceResult;
import com.yizhiquan.stockadmin.stockadmin.domain.SaleProduct;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.PageData;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.SaleProductVo;
import com.yizhiquan.stockadmin.stockadmin.service.SaleProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sale")
@Slf4j
public class SaleAction {
    private SaleProductService saleProductService;

    @Autowired
    SaleAction(SaleProductService saleProductService){
        this.saleProductService=saleProductService;
    }

    @GetMapping("/list")
    public ModelAndView saleProductListPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageMenuName", PageEnum.SALES_PRODUCT_PAGE.getPageCode());
        modelAndView.setViewName("sale/sale_list");
        return modelAndView;
    }

    @GetMapping("/findList")
    @ResponseBody
    public ServiceResult findList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        Page<SaleProduct> saleProductList=saleProductService.findListPage(pageNum,pageSize);
        return ResultWrapper.success(saleProductList);
    }

    @PostMapping("/saveSaleProduct")
    @ResponseBody
    public ServiceResult saveSaleProduct(SaleProductVo saleProduct) throws Exception {
        System.out.println(JSON.toJSONString(saleProduct));
        saleProductService.saveSaleProduct(saleProduct);
        return ResultWrapper.success();
    }

}

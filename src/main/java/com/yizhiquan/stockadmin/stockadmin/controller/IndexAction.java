package com.yizhiquan.stockadmin.stockadmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/6/11 13:34
 * @Modified By:
 */
@RestController
public class IndexAction {

    @GetMapping("index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("list")
    public ModelAndView list(){
        return new ModelAndView("product/lyear_pages_doc");
    }
}

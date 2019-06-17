package com.yizhiquan.stockadmin.stockadmin.controller;

import com.yizhiquan.stockadmin.stockadmin.common.constant.PageEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/6/11 13:34
 * @Modified By:
 */
@Controller
public class IndexAction {

    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("pageMenuName", PageEnum.HOME_INDEX_PAGE.getPageCode());
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView list(){
        return new ModelAndView("product/lyear_pages_doc");
    }
}

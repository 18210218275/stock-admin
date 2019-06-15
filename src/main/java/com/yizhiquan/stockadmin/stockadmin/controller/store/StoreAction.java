package com.yizhiquan.stockadmin.stockadmin.controller.store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/6/11 16:56
 * @Modified By:
 */
@RestController
@RequestMapping("/store")
public class StoreAction {

    @GetMapping("/list")
    public ModelAndView listStore(){

        return new ModelAndView("store_list1");
    }

}

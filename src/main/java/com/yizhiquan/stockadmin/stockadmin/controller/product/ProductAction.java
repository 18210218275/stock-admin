package com.yizhiquan.stockadmin.stockadmin.controller.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/product")
public class ProductAction {

    @GetMapping("/list")
    public ModelAndView productList(){
        return new ModelAndView("product/product_list");
    }
}

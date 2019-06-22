package com.yizhiquan.stockadmin.stockadmin.controller.product;

import com.alibaba.fastjson.JSON;
import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;
import com.yizhiquan.stockadmin.stockadmin.service.ProductService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductAction {
    private ProductService productService;

    @Autowired
    public ProductAction(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/list")
    public ModelAndView productList(){
        return new ModelAndView("product/product_list");
    }

    @GetMapping("/edit")
    public ModelAndView editProduct(){
        return new ModelAndView("product/product_add");
    }

    @GetMapping("/findProductByCode")
    public Product findProductByCode(@RequestParam("productCode") String productCode){
        Product product=productService.selectProductByCode(productCode);
        return product;
    }

    @GetMapping("/addProduct")
    public String addProduct(Product product){
        Map<String,Object>  resultMap=new HashMap<>();
        productService.saveProduct(product);
        resultMap.put("result",true);
        resultMap.put("id",product.getId());
        return JSON.toJSONString(resultMap);
    }

    @PostMapping("/addProductSpec")
    public String addProductSpec(ProductSpec productSpec){
        productService.saveProductSpec(productSpec);
        return "";
    }
}

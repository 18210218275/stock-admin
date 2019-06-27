package com.yizhiquan.stockadmin.stockadmin.controller.product;

import com.alibaba.fastjson.JSON;
import com.yizhiquan.stockadmin.stockadmin.domain.Brand;
import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;
import com.yizhiquan.stockadmin.stockadmin.service.BrandService;
import com.yizhiquan.stockadmin.stockadmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductAction {
    private ProductService productService;

    private BrandService brandService;

    @Autowired
    public ProductAction(ProductService productService, BrandService brandService){
        this.productService=productService;
        this.brandService=brandService;
    }

    @GetMapping("/list")
    public ModelAndView productList(){
        return new ModelAndView("product/product_list");
    }

    @GetMapping("/edit")
    public ModelAndView editProduct(){
        List<Brand> brandList = brandService.findAllBrand();
        ModelAndView model = new ModelAndView("product/product_add");
        model.setViewName("product/product_add");
        model.addObject("brandList",brandList);
        return model;
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
        return "Success";
    }
}

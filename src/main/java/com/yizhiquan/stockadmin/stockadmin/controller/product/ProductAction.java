package com.yizhiquan.stockadmin.stockadmin.controller.product;

import com.alibaba.fastjson.JSON;
import com.yizhiquan.stockadmin.stockadmin.common.constant.PageEnum;
import com.yizhiquan.stockadmin.stockadmin.common.exception.ResultWrapper;
import com.yizhiquan.stockadmin.stockadmin.common.exception.ServiceResult;
import com.yizhiquan.stockadmin.stockadmin.domain.Brand;
import com.yizhiquan.stockadmin.stockadmin.domain.Product;
import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;
import com.yizhiquan.stockadmin.stockadmin.domain.dto.TransferReq;
import com.yizhiquan.stockadmin.stockadmin.service.BrandService;
import com.yizhiquan.stockadmin.stockadmin.service.ProductService;
import com.yizhiquan.stockadmin.stockadmin.service.ProductWarehouseStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductAction {
    private ProductService productService;

    private BrandService brandService;

    private ProductWarehouseStockService productWarehouseStockService;

    @Autowired
    public ProductAction(ProductService productService, BrandService brandService, ProductWarehouseStockService productWarehouseStockService){
        this.productService=productService;
        this.brandService=brandService;
        this.productWarehouseStockService=productWarehouseStockService;
    }

    @GetMapping("/list")
    public ModelAndView productList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageMenuName", PageEnum.PRODUCT_LIST_PAGE.getPageCode());
        modelAndView.setViewName("product/product_list");
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView editProduct(){
        List<Brand> brandList = brandService.findAllBrand();
        ModelAndView model = new ModelAndView();
        model.setViewName("product/product_add");
        model.addObject("pageMenuName", PageEnum.ADD_PRODUCT_PAGE.getPageCode());
        model.addObject("brandList",brandList);
        return model;
    }

    @GetMapping("/findProductByCode")
    @ResponseBody
    public ServiceResult findProductByCode(@RequestParam("productCode") String productCode){
        Product product=productService.selectProductByCode(productCode);
        System.out.println(JSON.toJSONString(product));
        return ResultWrapper.success(product);
    }

    @PostMapping("/saveMainProduct")
    @ResponseBody
    public ServiceResult saveMainProduct(Product product){
        productService.saveProduct(product);
        return ResultWrapper.success(product);
    }

    @PostMapping("/saveProductSpec")
    @ResponseBody
    public ServiceResult saveProductSpec(ProductSpec productSpec) {
        productService.saveProductSpec(productSpec);
        log.info(JSON.toJSONString(productSpec));
        return ResultWrapper.success(productSpec);
    }

    /*@PostMapping("/addProductSpec")
    public String addProductSpec(ProductSpec productSpec){
        productService.saveProductSpec(productSpec);
        return "Success";
    }*/

    @GetMapping("/transfer")
    public ModelAndView transferProductPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/product_transfer");
        modelAndView.addObject("pageMenuName", PageEnum.TRANSFER_PRODUCT_PAGE.getPageCode());
        return modelAndView;
    }

    @PostMapping("/saveTransfer")
    @ResponseBody
    public ServiceResult saveTransferProduct(@RequestBody List<TransferReq> transferReqList){
        productService.saveTransferProduct(transferReqList);

        return ResultWrapper.success();
    }

    @GetMapping("/stockProductByProductCode")
    @ResponseBody
    public ServiceResult findProductWarehouseByProductCode(@RequestParam("productKey") String productCode){
        List<Product> productList= productService.findProductWarehouseByProductCode(productCode);
        return ResultWrapper.success(productList);
    }

}

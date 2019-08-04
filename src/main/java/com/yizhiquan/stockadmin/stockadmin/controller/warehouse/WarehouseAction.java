package com.yizhiquan.stockadmin.stockadmin.controller.warehouse;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.yizhiquan.stockadmin.stockadmin.common.constant.PageEnum;
import com.yizhiquan.stockadmin.stockadmin.common.exception.ResultWrapper;
import com.yizhiquan.stockadmin.stockadmin.common.exception.ServiceResult;
import com.yizhiquan.stockadmin.stockadmin.domain.Warehouse;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.PageData;
import com.yizhiquan.stockadmin.stockadmin.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/warehouse")
@Slf4j
public class WarehouseAction {
    private WarehouseService warehouseService;

    public WarehouseAction(WarehouseService warehouseService){
        this.warehouseService=warehouseService;
    }

    @GetMapping("/list")
    public ModelAndView stockList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("warehouse/warehouse_list");
        modelAndView.addObject("pageMenuName", PageEnum.WAREHOUSE_LIST_PAGE.getPageCode());
        return modelAndView;
    }

    @PostMapping("/saveWarehouse")
    @ResponseBody
    public String saveWarehouse(Warehouse warehouse){
        log.info("获取到的参数： "+ JSON.toJSONString(warehouse));
        System.out.println(JSON.toJSONString(warehouse));
        warehouseService.saveWarehouse(warehouse);
        return JSON.toJSONString(warehouse);
    }

    @RequestMapping("/findList")
    @ResponseBody
    public String findWarehouseList(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        PageData<Warehouse> warehouseList=warehouseService.findWarehouseList(pageNum,pageSize);
        log.info(JSON.toJSONString(warehouseList));
        return JSON.toJSONString(warehouseList);
    }

    @GetMapping("/findAllList")
    @ResponseBody
    public ServiceResult findAllWarehouseList(){
        List<Warehouse> warehouseList=warehouseService.findAllWarehouseList();
        System.out.println(JSON.toJSONString(warehouseList));
        return ResultWrapper.success(warehouseList);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ServiceResult deleteWarehouse(@RequestParam("id") Integer id){
        warehouseService.deleteWarehouse(id);
        return ResultWrapper.success();
    }

    @GetMapping("/getWarehouseById")
    @ResponseBody
    public ServiceResult getWarehouseById(@RequestParam("id") Integer id){
        Warehouse warehouse=warehouseService.getWarehouseById(id);
        return ResultWrapper.success(warehouse);
    }
}

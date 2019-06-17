package com.yizhiquan.stockadmin.stockadmin.controller.store;

import com.alibaba.fastjson.JSON;
import com.yizhiquan.stockadmin.stockadmin.common.constant.PageEnum;
import com.yizhiquan.stockadmin.stockadmin.domain.Store;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.PageData;
import com.yizhiquan.stockadmin.stockadmin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/6/11 16:56
 * @Modified By:
 */
@Controller
@RequestMapping("/store")
public class StoreAction {
    private StoreService storeService;

    @Autowired
    public StoreAction(StoreService storeService){
        this.storeService=storeService;
    }

    @GetMapping("/list")
    public ModelAndView listStore(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageMenuName", PageEnum.STORE_LIST_PAGE.getPageCode());
        modelAndView.setViewName("store/store_list");
        return modelAndView;
    }

    @PostMapping("/saveStore")
    @ResponseBody
    public String saveStore(Store store){
        storeService.saveStore(store);
        return JSON.toJSONString(store);
    }

    @GetMapping("/findList")
    @ResponseBody
    public String findList(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        PageData<Store> storeList=storeService.findStoreList(pageNum,pageSize);
        return JSON.toJSONString(storeList);
    }

}

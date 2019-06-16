package com.yizhiquan.stockadmin.stockadmin.common.constant;


import lombok.Getter;

@Getter
public enum PageEnum {

    BRAND_LIST_PAGE("brandList","品牌管理页面"),

    STORE_LIST_PAGE("storeList","店铺管理列表页"),

    WAREHOUSE_LIST_PAGE("warehouseList","仓库管理列表页");

    private String pageCode;

    private String pageTitle;

    PageEnum(String pageCode,String pageTitle){
        this.pageCode=pageCode;
        this.pageTitle=pageTitle;
    }
}

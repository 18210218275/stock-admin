package com.yizhiquan.stockadmin.stockadmin.common.constant;


import lombok.Getter;

@Getter
public enum PageEnum {

    BRAND_LIST_PAGE("brandList","品牌管理页面"),

    STORE_LIST_PAGE("storeList","店铺管理列表页"),

    HOME_INDEX_PAGE("homeIndex","首页"),

    WAREHOUSE_LIST_PAGE("warehouseList","仓库管理列表页"),

    PRODUCT_LIST_PAGE("productList","商品列表页"),

    ADD_PRODUCT_PAGE("addProduct","录入商品页"),

    TRANSFER_PRODUCT_PAGE("transferProduct","调拨商品页");

    private String pageCode;

    private String pageTitle;

    PageEnum(String pageCode,String pageTitle){
        this.pageCode=pageCode;
        this.pageTitle=pageTitle;
    }
}

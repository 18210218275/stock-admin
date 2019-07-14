package com.yizhiquan.stockadmin.stockadmin.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductSpec {
    private Integer id;

    private Integer productId;

    private String color;

    private String size;

    private Integer quantity;

    private String purchaseTime;

    private Date createTime;

    private List<ProductWarehouseStock> productWarehouseStockList;
}
package com.yizhiquan.stockadmin.stockadmin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
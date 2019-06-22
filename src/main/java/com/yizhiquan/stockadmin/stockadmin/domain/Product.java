package com.yizhiquan.stockadmin.stockadmin.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Product {
    private Integer id;

    private String productName;

    private String productCode;

    private Integer brandId;

    private String timeToMarket;

    private Double marketPrice;

    private Double salePrice;

    private String size;

    private String color;

    private Integer quantity;

    private Byte sex;

    private Integer clothingType;

    private Date purchaseTime;

    private Date createTime;

    private List<ProductSpec> productSpecList;

}
package com.yizhiquan.stockadmin.stockadmin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleProduct {
    private Integer id;

    private String productCode;

    private String productName;

    private Integer storeId;

    private String salesperson;

    private Integer quantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date saleTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private Double totalMoney;

    private String color;

    private String size;
}
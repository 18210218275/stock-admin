package com.yizhiquan.stockadmin.stockadmin.domain.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SaleProductVo  {
    private Integer id;

    private Integer productId;

    private String productCode;

    private String productName;

    private Integer storeId;

    private String salesperson;

    private Integer quantity;

    private String saleTime;

    private Date createTime;

    private Double totalMoney;

    private String color;

    private String size;
}

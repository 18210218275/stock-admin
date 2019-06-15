package com.yizhiquan.stockadmin.stockadmin.domain;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Brand {
    private Integer id;

    private String brandNameCn;

    private String brandNameEn;

    private Integer type;

    private Date createTime;
}
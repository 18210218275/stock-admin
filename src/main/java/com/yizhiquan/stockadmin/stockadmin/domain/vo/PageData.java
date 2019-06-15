package com.yizhiquan.stockadmin.stockadmin.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageData<T> {
    private Integer pageNum;

    private Integer pageSize;

    private Long total;

    private List<T> data;
}
package com.yizhiquan.stockadmin.stockadmin.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransferReq implements Serializable {
    /**
     * 商品明细Id
     */
    private Integer specId;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 调入仓库
     */
    private int warehouseId;
    /**
     * 调拨数量
     */
    private int quantity;

    /**
     * 存储主键
     */
    private Integer stockId;

}

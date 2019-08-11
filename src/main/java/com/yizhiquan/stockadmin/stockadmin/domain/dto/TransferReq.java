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
     * 从原始调拨量
     */
    private int orginalQuantity;

    /**
     * 原始仓库
     */
    private Integer orginalWarehouseId;

    /**
     * 存储主键
     */
    private Integer stockId;

    /**
     *  品牌名称
     */
    private String brandName;

    /**
     * 仓库名称
     */
    private String warehouseName;
}

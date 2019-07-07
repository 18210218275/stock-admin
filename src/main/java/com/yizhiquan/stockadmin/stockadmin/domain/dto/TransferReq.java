package com.yizhiquan.stockadmin.stockadmin.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransferReq implements Serializable {
    /**
     * 商品明细Id
     */
    private int specId;
    /**
     * 调出仓库
     */
    private int outWarehouseId;
    /**
     * 调入仓库
     */
    private int inWarehouseId;
    /**
     * 调拨数量
     */
    private int quantity;

}

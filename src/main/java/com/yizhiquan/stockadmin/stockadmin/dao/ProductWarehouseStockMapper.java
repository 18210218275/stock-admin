package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.ProductWarehouseStock;
import com.yizhiquan.stockadmin.stockadmin.domain.dto.TransferReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductWarehouseStockMapper {
    int insert(ProductWarehouseStock record);

    int insertSelective(ProductWarehouseStock record);

    void batchInsert(@Param("transferList") List<TransferReq> transferReqList);

    void batchUpdate(@Param("existTransferList") List<TransferReq> existTransferList);
}
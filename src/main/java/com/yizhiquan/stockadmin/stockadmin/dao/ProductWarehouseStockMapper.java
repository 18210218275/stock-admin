package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.ProductWarehouseStock;
import com.yizhiquan.stockadmin.stockadmin.domain.dto.TransferReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ProductWarehouseStockMapper {
    int insert(ProductWarehouseStock record);

    int insertSelective(ProductWarehouseStock record);

    void batchInsert(@Param("transferList") List<TransferReq> transferReqList);

    void batchUpdate(@Param("existTransferList") List<TransferReq> existTransferList,@Param("inputOrOutput") boolean inputOrOutput);

    ProductWarehouseStock selectBySpecAndProduct(ProductWarehouseStock warehouseStock);

    void updateProductStock(ProductWarehouseStock stock);

    List<ProductWarehouseStock> selectStockByIds(@Param("stockSet") Set<Integer> stockSet);

    ProductWarehouseStock selectStockById(@Param("stockId") Integer stockId);
}
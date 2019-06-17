package com.yizhiquan.stockadmin.stockadmin.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yizhiquan.stockadmin.stockadmin.dao.WarehouseMapper;
import com.yizhiquan.stockadmin.stockadmin.domain.Warehouse;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.PageData;
import com.yizhiquan.stockadmin.stockadmin.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {
    private WarehouseMapper warehouseMapper;

    @Autowired
    public WarehouseServiceImpl(WarehouseMapper warehouseMapper){
        this.warehouseMapper=warehouseMapper;
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void saveWarehouse(Warehouse warehouse) {
        warehouseMapper.insertSelective(warehouse);
    }

    @Override
    public PageData findWarehouseList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Warehouse> warehousePages=warehouseMapper.selectWarehouse();
        PageData<Warehouse> warehousePageData = PageData.<Warehouse>builder()
                .pageNum(pageNum)
                .pageSize(pageSize)
                .totalNum(warehousePages.getTotal())
                .totalPage(warehousePages.getPages())
                .data(warehousePages.getResult())
                .build();

        log.info("分页查询返回数据：{}",JSON.toJSONString(warehousePages));
        return warehousePageData;
    }
}

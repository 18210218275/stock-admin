package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.Store;

public interface StoreMapper {
    int insert(Store record);

    int insertSelective(Store record);
}
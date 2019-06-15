package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.Store;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {
    int insert(Store record);

    int insertSelective(Store record);
}
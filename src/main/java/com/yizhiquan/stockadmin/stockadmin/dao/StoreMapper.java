package com.yizhiquan.stockadmin.stockadmin.dao;

import com.github.pagehelper.Page;
import com.yizhiquan.stockadmin.stockadmin.domain.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreMapper {
    int insert(Store record);

    int insertSelective(Store record);

    /**
     * 查询店铺列表
     * @return
     */
    Page<Store> selectStore();

    void deleteStore(@Param("id") Integer id);

    Store getStoreById(@Param("id") Integer id);

    void updateStore(Store store);
}
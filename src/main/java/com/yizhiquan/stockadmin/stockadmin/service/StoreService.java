package com.yizhiquan.stockadmin.stockadmin.service;

import com.yizhiquan.stockadmin.stockadmin.domain.Store;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.PageData;

public interface StoreService {
    /**
     * 保存店铺信息
     * @param store
     */
    void saveStore(Store store);

    /**
     * 分页查找店铺信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageData<Store> findStoreList(int pageNum, int pageSize);
}

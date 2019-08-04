package com.yizhiquan.stockadmin.stockadmin.service;

import com.github.pagehelper.Page;
import com.yizhiquan.stockadmin.stockadmin.domain.Warehouse;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.PageData;

import java.util.List;

public interface WarehouseService {

    /**
     *
     * @param warehouse
     */
    void saveWarehouse(Warehouse warehouse);

    /**
     * 分页查找仓库
     * @param pageSize
     * @param pageNum
     * @return
     */
    PageData findWarehouseList(int pageNum, int pageSize);

    /**
     * 查询所有的仓库
     * @return
     */
    List<Warehouse> findAllWarehouseList();

    /**
     * 删除指定的仓库
     * @param id
     */
    void deleteWarehouse(Integer id);

    Warehouse getWarehouseById(Integer id);
}

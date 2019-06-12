package com.yizhiquan.stockadmin.stockadmin.dao;

import com.yizhiquan.stockadmin.stockadmin.domain.PoLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/6/12 11:49
 * @Modified By:
 */
@Mapper
public interface PoLogDao {
    /**
     * @Author:luqinshun
     * @Description: 插入数据
     * @params: poLog
     */
    void insert(PoLog poLog);
}

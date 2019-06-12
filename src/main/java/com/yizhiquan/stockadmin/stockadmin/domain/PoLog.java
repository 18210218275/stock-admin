package com.yizhiquan.stockadmin.stockadmin.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author:luqinshun
 * @Description: 记录日志
 * @Date: Created in 2019/6/12 11:43
 * @Modified By:
 */
@Data
@Builder
public class PoLog {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 日志信息
     */
    private String logInfo;
    /**
     * 日志级别
     */
    private String logLevel;
    /**
     * 生成时间
     */
    private Date createTime;
}

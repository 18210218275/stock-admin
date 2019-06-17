package com.yizhiquan.stockadmin.stockadmin.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

import java.util.Date;

@Data
public class Warehouse {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 仓库名称
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String warehouseName;
    /**
     * 仓库地址
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String warehouseAddress;
    /**
     * 仓库投入使用时间
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String buildDate;
    /**
     * 仓库类型
     */
    private Integer type;
    /**
     * 创建数据时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 备注
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String remarks;

}
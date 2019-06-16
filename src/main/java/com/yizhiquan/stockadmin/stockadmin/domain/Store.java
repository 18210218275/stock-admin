package com.yizhiquan.stockadmin.stockadmin.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

import java.util.Date;

@Data
public class Store {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 店铺名称
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String storeName;
    /**
     * 店铺地址
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String storeAddress;
    /**
     * 店铺电话
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String telephone;
    /**
     * 店长
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String manager;
    /**
     * 店铺开业时间
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String startBusinessTime;
    /**
     * 店铺类型
     */
    private Byte type;
    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
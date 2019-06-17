package com.yizhiquan.stockadmin.stockadmin.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

import java.util.Date;

/**
 * 品牌实体
 */
@Data
public class Brand {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 品牌中文名
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String brandNameCn;
    /**
     * 品牌英文名
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String brandNameEn;
    /**
     * 品牌编码
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteNullStringAsEmpty)
    private String brandCode;
    /**
     * 品牌类型
     */
    private Integer type;
    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
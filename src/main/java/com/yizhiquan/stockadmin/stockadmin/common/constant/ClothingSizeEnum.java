package com.yizhiquan.stockadmin.stockadmin.common.constant;

import lombok.Getter;

/**
 * 衣服尺码
 */
@Getter
public enum ClothingSizeEnum {
    XS_SIZE(160,"160/42/XS"),
    S_SIZE(165,"165/44/S"),
    M_SIZE(170,"170/46/M"),
    L_SIZE(175,"175/48/L"),
    XL_SIZE(180,"180/50/XL"),
    XXL_SIZE(185,"185/52/XXL"),
    XXXL_SIZE(190,"190/54/XXXL");

    private int code;

    private String sizeName;

    ClothingSizeEnum(int code,String sizeName){
        this.code=code;
        this.sizeName=sizeName;
    }
}

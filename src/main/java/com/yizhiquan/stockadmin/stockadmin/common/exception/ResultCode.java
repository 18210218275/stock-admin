package com.yizhiquan.stockadmin.stockadmin.common.exception;

import lombok.Getter;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/6/28 14:40
 * @Modified By:
 */
@Getter
public enum ResultCode {
    /** 操作成功 */
    SUCCESS(200, "操作成功"),
    /** 操作失败 */
    FAILURE(400, "操作失败"),
    /** 用户获取失败 */
    UNAUTHORIZED(403, "用户获取失败"),
    /** 请求地址不存在 */
    NO_ERROR(404, "请求地址不存在"),
    /** 系统内部错误 */
    SERVER_ERROR(500, "系统内部错误"),
    /** 参数错误 */
    INVALID_PARAM(600, "参数错误");

    private int code;

    private String message;

    ResultCode(int code,String message){
        this.code=code;
        this.message=message;
    }
}

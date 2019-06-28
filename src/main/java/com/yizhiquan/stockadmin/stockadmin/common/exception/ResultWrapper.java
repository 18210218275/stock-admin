package com.yizhiquan.stockadmin.stockadmin.common.exception;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/6/28 14:47
 * @Modified By:
 */
public class ResultWrapper {
    public static ServiceResult success() {
        return new ServiceResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    public static ServiceResult success(Object data) {
        return new ServiceResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static ServiceResult fail(ResultCode code) {
        return new ServiceResult(code.getCode(), code.getMessage());
    }

    public static ServiceResult fail(ResultCode code,Object data) {
        return new ServiceResult(code.getCode(), code.getMessage(),data);
    }

    public static ServiceResult response(Integer code, String msg) {
        return new ServiceResult(code, msg);
    }
}

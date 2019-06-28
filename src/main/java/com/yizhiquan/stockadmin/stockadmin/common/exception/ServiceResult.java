package com.yizhiquan.stockadmin.stockadmin.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/6/28 14:17
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResult<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public ServiceResult(int code){
        this.code=code;
    }

    public ServiceResult(int code,String message){
        this.code=code;
        this.message=message;
    }
}

package com.yizhiquan.stockadmin.stockadmin.config;

import com.yizhiquan.stockadmin.stockadmin.common.exception.ResultCode;
import com.yizhiquan.stockadmin.stockadmin.common.exception.ResultWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/6/28 11:47
 * @Modified By:
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(){
        return ResultWrapper.fail(ResultCode.SERVER_ERROR);
    }
}

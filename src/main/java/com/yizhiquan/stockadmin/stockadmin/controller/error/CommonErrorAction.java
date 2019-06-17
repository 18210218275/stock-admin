package com.yizhiquan.stockadmin.stockadmin.controller.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommonErrorAction implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return "error/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

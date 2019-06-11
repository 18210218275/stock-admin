package com.yizhiquan.stockadmin.stockadmin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/6/11 11:54
 * @Modified By:
 */
public class ServletInitalizer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StockAdminApplication.class);
    }
}

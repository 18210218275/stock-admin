package com.yizhiquan.stockadmin.stockadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class StockAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockAdminApplication.class, args);
    }

}

package com.easylive.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.easylive.mapper")
@SpringBootApplication(scanBasePackages = {"com.easylive"})
public class EasyliveWebRunApplication {
    public static void main(String[] args) {

        SpringApplication.run(EasyliveWebRunApplication.class, args);
    }
}

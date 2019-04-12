package com.heyang.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(value = {"com.heyang.mall.service","com.heyang.mall.component","com.heyang.mall.util","com.heyang.mall.config","com.heyang.mall.controller"})
@MapperScan(value = {"com.heyang.mall.mapper","com.heyang.mall.dao"})
public class MallselfAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallselfAdminApplication.class, args);
    }

}

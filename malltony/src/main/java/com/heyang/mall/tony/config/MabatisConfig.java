package com.heyang.mall.tony.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 86137 on 2019/5/12.
 */
@Configuration
@MapperScan({"com.heyang.mall.tony.mbg.mapper","com.heyang.mall.tony.dao"})
public class MabatisConfig {
}

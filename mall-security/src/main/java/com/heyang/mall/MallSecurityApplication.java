package com.heyang.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.wechat.autoconfigurer.WechatMpAutoConfiguration;

@SpringBootApplication
@EnableSocial
public class MallSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSecurityApplication.class, args);
    }

}

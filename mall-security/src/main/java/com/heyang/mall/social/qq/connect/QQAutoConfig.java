package com.heyang.mall.social.qq.connect;

import com.heyang.mall.social.api.rewrite.code.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.github.connect.GitHubConnectionFactory;

/**
 * QQ登录配置
 */
@Configuration
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {

        super.addConnectionFactories(connectionFactoryConfigurer, environment);
        String providerId = "qq";   //第三方id，用来决定发起第三方登录的url，默认是weixin
        String appId = "2aa8659297ecd2b202b6";
        String appSecret = "6a943e680a302f859e042f290c001a5015dd339b";
        connectionFactoryConfigurer.addConnectionFactory(new QQConnectionFactory(providerId,appId,
                appSecret));
    }

}
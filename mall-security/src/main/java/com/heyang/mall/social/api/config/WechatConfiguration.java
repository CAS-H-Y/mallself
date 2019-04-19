package com.heyang.mall.social.api.config;

import com.heyang.mall.social.api.rewrite.code.ConnectController;
import com.heyang.mall.social.api.rewrite.code.SocialAutoConfigurerAdapter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.connect.GitHubConnectionFactory;
import org.springframework.social.wechat.api.Wechat;
import org.springframework.social.wechat.connect.WechatConnectionFactory;

/**
 * creat on 2019/4/15
 * <p>
 * #author : CAS_hy
 **/
//@Configuration
//@EnableConfigurationProperties(WechatProperties.class)
//public class WechatConfiguration extends SocialAutoConfigurerAdapter {
//    @Override
//    @Bean
//    public UserIdSource getUserIdSource() {
//        return new UserIdSource() {
//            @Override
//            public String getUserId() {
//                return "";
//            }
//        };
//    }
//
//    private final WechatProperties properties;
//
//    public WechatConfiguration(WechatProperties properties) {
//        this.properties = properties;
//    }
//
//    @Bean
//    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
//    public Wechat wetcChar(ConnectionRepository repository) {
//        Connection<Wechat> connection = repository
//                .findPrimaryConnection(Wechat.class);
//
//        return connection != null ? connection.getApi() : null;
//    }
//
//    @Override
//    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
//
//        super.addConnectionFactories(connectionFactoryConfigurer, environment);
//        connectionFactoryConfigurer.addConnectionFactory(new WechatConnectionFactory(properties.getAppId(),
//                properties.getAppSecret()));
//    }
//
//    @Bean
//    public ConnectController connectController(
//            ConnectionFactoryLocator factoryLocator,
//            ConnectionRepository repository) {
//
//        ConnectController controller = new ConnectController(
//                factoryLocator, repository);
//        controller.setApplicationUrl("http://localhost:8080");
//        return controller;
//    }
//    @Bean
//    public ProviderSignInController providerSignInController(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository usersConnectionRepository, WechatSignInAdapter wechatSignInAdapter) {
//        ((InMemoryUsersConnectionRepository) usersConnectionRepository).setConnectionSignUp((Connection<?> connection) -> connection.getKey().getProviderUserId());
//        return new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, wechatSignInAdapter);
//    }
//}

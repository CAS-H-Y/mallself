package com.heyang.mall.social.api.rewrite.code;

import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.github.connect.GitHubConnectionFactory;

public abstract class SocialAutoConfigurerAdapter extends SocialConfigurerAdapter {


    public SocialAutoConfigurerAdapter() {

    }
}
package com.heyang.mall.social.api.config;

import com.heyang.mall.social.api.rewrite.code.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.social.config.annotation.SocialConfigurer;

@ConfigurationProperties(prefix = "spring.social.github")
public class GitHubProperties extends SocialProperties {

}
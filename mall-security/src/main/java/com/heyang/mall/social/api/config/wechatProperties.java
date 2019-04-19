package com.heyang.mall.social.api.config;

import com.heyang.mall.social.api.rewrite.code.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * creat on 2019/4/15
 * <p>
 * #author : CAS_hy
 **/
@ConfigurationProperties(prefix="spring.social.wechatmp")
public class wechatProperties extends SocialProperties {
}

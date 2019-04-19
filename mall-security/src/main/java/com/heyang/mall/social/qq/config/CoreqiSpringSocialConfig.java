package com.heyang.mall.social.qq.config;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

public class CoreqiSpringSocialConfig extends SpringSocialConfigurer {

    /**
     *
     * @param object
     * @param <T>
     * @return
     */
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter)super.postProcess(object);
        filter.setFilterProcessesUrl("/hello");
        return (T) filter;
    }
}
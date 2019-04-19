package com.heyang.mall.social.api.config;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.wechat.api.User;
import org.springframework.social.wechat.api.Wechat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class WechatSignInAdapter implements SignInAdapter {

    @Override
    public String signIn(String openId, Connection<?> connection, NativeWebRequest request) {
        ConnectionKey key = connection.getKey();
        // 通过providerId判断是否为微信公众平台授权

        if ("wechatmp".equalsIgnoreCase(key.getProviderId())) {
            // 通过微信openId获取到用户详细信息
            User user = ((Wechat)connection.getApi()).userOperations().getUserProfile(openId);
            // 微信用户详细信息,可以记录到数据库.这里直接打印到后台
            System.out.println(user);
            return "/success.htm"; // 返回登录成功后跳转的url
        }
        return "/error.htm";
    }

}
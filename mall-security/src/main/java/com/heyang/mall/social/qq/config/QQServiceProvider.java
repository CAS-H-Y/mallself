package com.heyang.mall.social.qq.config;

import com.heyang.mall.social.qq.api.Impl.QQImpl;
import com.heyang.mall.social.qq.api.QQ;
import com.heyang.mall.social.qq.connect.QQAuth2Template;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import com.heyang.mall.social.qq.api.*;

public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

     private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";  //获取授权码地址
     private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";   //获取用户令牌地址

     private String appId;

     public QQServiceProvider(String appId,String appSecret) {
        super(new QQAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
        this.appId = appId;
     }

    @Override
    public QQ getApi(String accessToken) {
         return new QQImpl(accessToken,appId);
     }
 }
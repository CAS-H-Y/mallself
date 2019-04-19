package com.heyang.mall.social.qq.api.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heyang.mall.social.qq.api.QQ;
import com.heyang.mall.social.qq.api.QQUserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;

/**
 * creat on 2019/4/17
 * <p>
 * #author : CAS_hy
 **/
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    private ObjectMapper objectMapper = new ObjectMapper(); //用于序列化Json数据

    //获取openid的请求地址
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    //获取用户信息的请求地址
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    /**
     * appId 配置文件读取
     */
    private String appId;

    private String appSecret;
    /**
     * openId 请求QQ_URL_GET_OPENID返回
     */
    private String openId;
    /**
     * 构造方法获取openId
     */
    public QQImpl(String accessToken, String appId) {
        //access_token作为查询参数来携带。
        //super(appId,accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        super();
        this.appId = appId;

        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);

//        log.info("【QQImpl】 QQ_URL_GET_OPENID={} result={}", URL_GET_OPENID, result);

        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
    }


    @Override
    public QQUserInfo getUserInfo() {
        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);

//        log.info("【QQImpl】 QQ_URL_GET_USER_INFO={} result={}", URL_GET_USERINFO, result);

        QQUserInfo userInfo = null;
        try {
            userInfo = objectMapper.readValue(result, QQUserInfo.class);
            userInfo.setOpenid(openId);
            return userInfo;
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败", e);
        }
    }

}

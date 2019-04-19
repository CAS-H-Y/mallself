package com.heyang.mall.social.qq.connect;


import com.heyang.mall.social.qq.api.QQ;
import com.heyang.mall.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import java.io.IOException;

/**
 *  泛型是指当前API适配器适配API的类型是什么
 */
    public class QQAdapter implements ApiAdapter<QQ> {

        /**
         * 用来测试当前的API是否可用
         * @param qq
         * @return
         */
        @Override
        public boolean test(QQ qq) {
            return true;
        }

        /**
         * 将服务提供商个性化的用户信息映射到ConnectionValues标准的数据化结构上
         * @param qq
         * @param connectionValues
         */
        @Override
        public void setConnectionValues(QQ qq, ConnectionValues connectionValues) {
            QQUserInfo userInfo = qq.getUserInfo();
            connectionValues.setDisplayName(userInfo.getNickname());  //显示的用户名称
            //connectionValues.setImageUrl(userInfo.getFigureurl_qq_1()); //用户的头像
            connectionValues.setProfileUrl(null);   //个人主页
            //connectionValues.setProviderUserId(userInfo.getOpenId());   //QQ的唯一标识
        }

        /**
         * 和上面的方法类似
         * @param qq
         * @return
         */
        @Override
        public UserProfile fetchUserProfile(QQ qq) {
            return null;
        }

        /**
         *
         * @param qq
         * @param s
         */
        @Override
        public void updateStatus(QQ qq, String s) {

        }
}
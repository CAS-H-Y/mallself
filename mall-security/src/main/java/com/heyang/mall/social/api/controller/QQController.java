package com.heyang.mall.social.api.controller;

import com.heyang.mall.social.qq.api.QQ;
import com.heyang.mall.social.qq.api.QQUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.github.api.GitHub;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * creat on 2019/4/17
 * <p>
 * #author : CAS_hy
 **/
@Controller
public class QQController {
    @Autowired
    private ConnectionRepository connectionRepository;


    @GetMapping("/auth/qq")
    public String  getSocialUserInfo(javax.servlet.http.HttpServletRequest request) {
        QQUserInfo userInfo = new QQUserInfo();
        Connection<?> connection = connectionRepository.findPrimaryConnection(QQ.class);
        System.out.println(connectionRepository.findAllConnections().size());
        if (connection == null) {
            return "redirect:/connect/github";
        }
        return "notnull";
    }
}

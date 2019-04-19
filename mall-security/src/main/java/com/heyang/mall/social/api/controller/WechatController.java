package com.heyang.mall.social.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * creat on 2019/4/16
 * <p>
 * #author : CAS_hy
 **/
@Controller
public class WechatController {

    @GetMapping
    public String test() {
        System.out.println("123");
        return "login";
    }

//    @GetMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
//    public ModelAndView require(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
//        return new ModelAndView("login", map);
//    }
}

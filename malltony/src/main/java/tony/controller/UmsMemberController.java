package com.heyang.mall.tony.controller;

import com.heyang.mall.tony.common.api.CommonResult;
import com.heyang.mall.tony.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 86137 on 2019/5/12.
 */
@RestController
@RequestMapping("/v1/ums")
public class UmsMemberController {

    @Autowired
    UmsMemberService umsMemberService;
    @GetMapping("/authcode")
    public CommonResult getauthcode(@RequestParam String telphone){
        return umsMemberService.getAuthCode(telphone);
    }

    @GetMapping("/checkauthcode")
    public CommonResult checkauthcode(@RequestParam String telphone,
                                      @RequestParam String authCode){
        return umsMemberService.checkAuthCode(telphone,authCode);
    }
}

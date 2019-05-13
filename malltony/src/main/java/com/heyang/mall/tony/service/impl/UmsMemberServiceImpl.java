package com.heyang.mall.tony.service.impl;

import com.heyang.mall.tony.common.api.CommonResult;
import com.heyang.mall.tony.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by 86137 on 2019/5/12.
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService{

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public CommonResult getAuthCode(String telphone) {
    StringBuilder sb=new StringBuilder();
        Random random=new Random();
       for(int i=0;i<6;i++){
       sb.append(random.nextInt());
       }
        redisTemplate.opsForValue().set(telphone,sb.toString());
        redisTemplate.expire("telphone",120, TimeUnit.SECONDS);
        return new CommonResult().success(sb.toString());
    }

    @Override
    public CommonResult checkAuthCode(String telphone, String authCode) {
        if("".equals(authCode)){
            return new CommonResult().validateFailed(("请输入验证码"));
        }
        String redisauthCode=(String)redisTemplate.opsForValue().get(telphone);
        if(!redisauthCode.equals(authCode)){
            return new CommonResult().validateFailed(("验证码不一致"));
        }
        return new CommonResult().success("验证码校验成功");
    }
}

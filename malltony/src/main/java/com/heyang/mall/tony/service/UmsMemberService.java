package com.heyang.mall.tony.service;

import com.heyang.mall.tony.common.api.CommonResult;

/**
 * Created by 86137 on 2019/5/12.
 */
public interface UmsMemberService {
    CommonResult getAuthCode(String telphone);
    CommonResult checkAuthCode(String telphone, String authCode);
}

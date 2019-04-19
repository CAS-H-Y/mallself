package com.heyang.mall.social.qq.api;

import lombok.Data;

/**
 * 微信返回的用户信息
 * Created on 2018/1/11.
 *
 * @author zlf
 * @since 1.0
 */
@Data
public class QQUserInfo {
    /**
     * 普通用户的标识，对当前开发者帐号唯一
     */
    private String openid;
    /**
     * 普通用户昵称
     */
    private String nickname;
    /**
     * 返回码
     */
    private String ret;
    /**
     * 普通用户性别，1为男性，2为女性
     */
    private String gender;
    /**
     * 是否是黄砖
     */
    private String is_yellow_vip;
    /**
     * VIp
     */
    private String vip;
    /**
     *
     */
    private String yellow_vip_level;
    /**
     *
     */
    private String level;

    /**
     *
     */
    private String is_yellow_year_vip;
}

package com.heyang.mall.tony.service;

import com.heyang.mall.tony.mbg.model.UmsAdmin;
import com.heyang.mall.tony.mbg.model.UmsAdminLoginLogExample;
import com.heyang.mall.tony.mbg.model.UmsPermission;

import java.util.List;

/**
 * Created by 86137 on 2019/5/12.
 */
public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String username);
    List<UmsPermission> getPermissionList(Long adminId);
    UmsAdmin register(UmsAdmin umsAdmin );
    String login(String username,String password);
}

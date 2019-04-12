package com.heyang.mall.service;

import com.heyang.mall.dto.CasPermission;
import com.heyang.mall.dto.CasUser;

import java.util.List;

public interface UserService {
    String login(String username,String password);
    CasUser getUserByUsername(String username);
    List<CasPermission> getPermissionList(Long id);
}

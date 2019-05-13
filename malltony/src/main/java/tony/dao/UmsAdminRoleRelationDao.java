package com.heyang.mall.tony.dao;

import com.heyang.mall.tony.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 86137 on 2019/5/12.
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}

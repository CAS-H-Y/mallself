package com.heyang.mall.dao;

import com.heyang.mall.dto.CasPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * creat on 2019/4/10
 * <p>
 * #author : CAS_hy
 **/
public interface CasUserRoleDao {
    List<CasPermission> getRolePermissionList(@Param("id") Long id);
}

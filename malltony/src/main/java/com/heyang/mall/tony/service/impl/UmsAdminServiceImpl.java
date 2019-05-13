package com.heyang.mall.tony.service.impl;

import com.heyang.mall.tony.dao.UmsAdminRoleRelationDao;
import com.heyang.mall.tony.mbg.mapper.UmsAdminMapper;
import com.heyang.mall.tony.mbg.model.UmsAdmin;
import com.heyang.mall.tony.mbg.model.UmsAdminExample;
import com.heyang.mall.tony.mbg.model.UmsPermission;
import com.heyang.mall.tony.service.UmsAdminService;
import com.heyang.mall.tony.util.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 86137 on 2019/5/12.
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    UmsAdminMapper umsAdminMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> umsAdminList= umsAdminMapper.selectByExample(example);
        if (umsAdminList != null && umsAdminList.size() > 0) {
            return umsAdminList.get(0);
        }
        return null;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {

        return adminRoleRelationDao.getPermissionList(adminId);
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdmin) {
        UmsAdmin umsAdmin1=new UmsAdmin();
        BeanUtils.copyProperties(umsAdmin,umsAdmin1);
        umsAdmin1.setCreateTime(new Date());
        umsAdmin1.setStatus(1);
        UmsAdminExample umsAdminExample=new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(umsAdmin1.getUsername());
        List<UmsAdmin> list=umsAdminMapper.selectByExample(umsAdminExample);
        if(list.size()<=0){
            umsAdmin1.setPassword(passwordEncoder.encode(umsAdmin1.getPassword()));
            umsAdminMapper.insert(umsAdmin1);

            return umsAdmin1;
        }

        return null;
    }

    @Override
    public String login(String username, String password) {
        String token="";
        UserDetails userDetails=userDetailsService.loadUserByUsername(username);
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        token=jwtTokenUtil.generateToken(userDetails);
        return token;
    }
}

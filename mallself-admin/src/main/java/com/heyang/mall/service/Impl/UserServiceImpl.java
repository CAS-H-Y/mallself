package com.heyang.mall.service.Impl;


import com.heyang.mall.dao.CasUserRoleDao;
import com.heyang.mall.dto.CasPermission;
import com.heyang.mall.dto.CasUser;
import com.heyang.mall.entity.UserDo;
import com.heyang.mall.mapper.CasPermissionMapper;
import com.heyang.mall.mapper.CasUserMapper;
import com.heyang.mall.service.UserService;
import com.heyang.mall.util.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * creat on 2019/4/9
 * <p>
 * #author : CAS_hy
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    CasUserMapper casUserMapper;
    @Autowired
    CasUserRoleDao casUserRoleDao;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String login(String username,String password) {
        String token=null;
       UserDetails userDetails= userDetailsService.loadUserByUsername(username);

        try{
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token=jwtTokenUtil.generateToken(userDetails);
        }catch (AuthenticationException e) {

        }

        return token;
    }

    @Override
    public CasUser getUserByUsername(String username) {
         UserDo userDo=casUserMapper.selectByUserName(username);
        CasUser casUser =new CasUser();
        BeanUtils.copyProperties(userDo,casUser);//BeanUtils.copyProperties("转换后的类", "要转换的类");
        // 间存在名称不相同的属性，则BeanUtils不对这些属性进行处理，需要手动处理
        System.out.println(casUser.toString());
        return casUser;
    }

    @Override
    public List<CasPermission> getPermissionList(Long id) {
        List<CasPermission> list=casUserRoleDao.getRolePermissionList(id);
        System.out.println(list.toArray());
        return list;
    }
}

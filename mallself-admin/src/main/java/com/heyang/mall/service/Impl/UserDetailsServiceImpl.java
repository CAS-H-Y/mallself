package com.heyang.mall.service.Impl;

import com.heyang.mall.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * creat on 2019/4/9
 * <p>
 * #author : CAS_hy
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    private UserRepository userdao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //UserDetail user = userdao.findByUsername(username);
        String user="user";
        UserDetails ud=null;
        if (user == null) {
         return null;
        } else {
            return ud;
        }
    }
}

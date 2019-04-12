package com.heyang.mall.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
    public UserDetails loadUserByUsername(String username);
}

package com.heyang.mall.security;

import java.util.Optional;

import com.heyang.mall.user.ClientUser;
import com.heyang.mall.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ClientUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository users;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<ClientUser> optionalUser = users.findByUsername(username);

        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("invalid username or password");
        }
//        ClientUser us=optionalUser.get();
//        us.setPassword(passwordEncoder.encode(us.getPassword()));
        return new ClientUserDetails(optionalUser.get());
    }

}

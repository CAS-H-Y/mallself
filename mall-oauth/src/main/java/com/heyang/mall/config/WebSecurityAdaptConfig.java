package com.heyang.mall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration              //开启三种可以在方法上面加权限控制的注解
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityAdaptConfig extends WebSecurityConfigurerAdapter {

    /**
     * 获取用户的验证配置类
     */
    @Autowired
    private UserDetailsService userDetailsService;
    /**
     * 加密配置
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * spring security设置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
//            // 基于token，所以不需要session
//              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("oauth/token","/callback/*","/mainpage.html","/index.html")

                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll().anyRequest().authenticated().and()
                .formLogin().and()
                .logout().permitAll().and()

                .csrf().disable();


         }

         /**
         * 权限管理器  AuthorizationServerConfigurerAdapter认证中心需要的AuthenticationManager需要
         */
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            //配置登录user验证处理器  以及密码加密器  好让认证中心进行验证
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        }

        /**
         * 需要配置这个支持password模式
         * support password grant type
         *
         * @return
         * @throws Exception
         */
        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return authenticationManager();
        }

    }
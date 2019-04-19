//package com.heyang.mall.security.config;
//
//
//import com.heyang.mall.social.SecurityConstants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.social.security.SpringSocialConfigurer;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//
//import java.util.List;
//
//
///**
// * SpringSecurity的配置
// * Created by macro on 2018/4/26.
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
////    @Autowired
////    private UserService userService;
//@Autowired
//private SpringSocialConfigurer merryyouSpringSocialConfigurer;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.headers().frameOptions().disable().and()
//                .formLogin()//使用表单登录，不再使用默认httpBasic方式
//                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)//如果请求的URL需要认证则跳转的URL
//                .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)//处理表单中自定义的登录URL
//                .and()
//                .apply(merryyouSpringSocialConfigurer)//社交登录
//                .and()
//                .rememberMe()
//                .userDetailsService(userDetailsService)
//                .and()
//                .sessionManagement()
//                .and()
//                .logout()
//                .logoutUrl("/signOut")//默认退出地址/logout
//                .logoutSuccessUrl("/")//退出之后跳转到注册页面
//                .deleteCookies("JSESSIONID")
//                .and()
//                .authorizeRequests().antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
//                SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM,
//                SecurityConstants.DEFAULT_REGISTER_URL,
//                SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
//                SecurityConstants.DEFAULT_SIGN_IN_URL_MOBILE_PAGE,
//                "/register",
//                "/socialRegister",//社交账号注册和绑定页面
//                "/user/register",//处理社交注册请求
//                "/social/info",//获取当前社交用户信息
//                "/session/invalid",
//                "/**/*.js",
//                "/**/*.css",
//                "/**/*.jpg",
//                "/**/*.png",
//                "/**/*.woff2",
//                "/code/*")
//                .permitAll()//以上的请求都不需要认证
//                //.antMatchers("/").access("hasRole('USER')")
//                .and()
//                .csrf().disable()//关闭csrd拦截
//        ;
//    }
//
//
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
////    @Bean
////    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
////        return new JwtAuthenticationTokenFilter();
////    }
//
//    /**
//     * 允许跨域调用的过滤器
//     */
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("*");
//        config.setAllowCredentials(true);
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setOrder(0);
//        return new CorsFilter(source);
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//}

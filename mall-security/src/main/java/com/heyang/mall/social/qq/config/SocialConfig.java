package com.heyang.mall.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {
    //社交配置的适配器,继承SocialConfigurerAdapter,加@Configuration和@EnableSocial(启动社交项目相应的特性)

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    /**
     *
     * @param connectionFactoryLocator  作用是去根据条件去查找应该用那个connectionFactory，因为系统中可能有很多的connectionFactory。
     * @return
     */
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        //第三个参数的作用是把插入到数据库的数据进行加解密
        JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(dataSource,connectionFactoryLocator, Encryptors.noOpText());
        //jdbcUsersConnectionRepository.setTablePrefix(); //设置数据表的前缀
        if(connectionSignUp != null){
            jdbcUsersConnectionRepository.setConnectionSignUp(connectionSignUp);
        }
        return jdbcUsersConnectionRepository;
    }

    /**
     * 声明后还需要加在SpringSecurity过滤器链上
     * @return
     */
    @Bean
    public SpringSocialConfigurer coreqiSocialSecurityConfig(){
        CoreqiSpringSocialConfig config = new CoreqiSpringSocialConfig();
        //config.signupUrl()
        config.signupUrl("/registry");  //当从业务系统中无法找到OAuth快捷登陆的用户，那么将用户引导到注册页面中
        return config;
    }

    //1.注册过程中如何拿到SpringSocial信息
    //2.注册完成后如何把业务系统的用户ID传给SpringSocial
    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator){
        return new ProviderSignInUtils(connectionFactoryLocator,getUsersConnectionRepository(connectionFactoryLocator));
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
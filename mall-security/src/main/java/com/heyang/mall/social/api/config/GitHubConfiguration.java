package com.heyang.mall.social.api.config;


import com.heyang.mall.social.api.rewrite.code.SocialAutoConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.*;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import com.heyang.mall.social.api.rewrite.code.ConnectController;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.connect.GitHubConnectionFactory;
import org.springframework.social.security.SpringSocialConfigurer;

@Configuration
@EnableConfigurationProperties(GitHubProperties.class)
public class GitHubConfiguration extends SocialAutoConfigurerAdapter {

	@Override
	@Bean
	public UserIdSource getUserIdSource() {
		return new UserIdSource() {
			@Override
			public String getUserId() {
					return "";
			}
		};
	}

	private final GitHubProperties properties;

	public GitHubConfiguration(GitHubProperties properties) {
		this.properties = properties;
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public GitHub gitHub(ConnectionRepository repository) {
		Connection<GitHub> connection = repository
				.findPrimaryConnection(GitHub.class);

		return connection != null ? connection.getApi() : null;
	}

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {

		super.addConnectionFactories(connectionFactoryConfigurer, environment);
		connectionFactoryConfigurer.addConnectionFactory(new GitHubConnectionFactory(properties.getAppId(),
				properties.getAppSecret()));
}

		@Bean
	public ConnectController connectController(
			ConnectionFactoryLocator factoryLocator,
			ConnectionRepository repository) {

		ConnectController controller = new ConnectController(
			factoryLocator, repository);
		controller.setApplicationUrl("http://localhost:8080");
		return controller;
	}


}
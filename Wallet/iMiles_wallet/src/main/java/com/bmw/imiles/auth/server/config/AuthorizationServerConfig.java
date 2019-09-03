package com.bmw.imiles.auth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Value("${spring.oauth.client_id}")
	private String clientId;
	
	@Value("${spring.oauth.client_secret}")
	private String clientSecret;
	
	@Value("${spring.oauth.grant_type_password}")
	private String grantTypePassword;
	
	@Value("${spring.oauth.authorization_code}")
	private String authorizationCode;
	
	@Value("${spring.oauth.refresh_token}")
	private String refreshToken;
	
	@Value("${spring.oauth.implicit}")
	private String implicit;
	
	@Value("${spring.oauth.scope_read}")
	private String scopeRead;
	
	@Value("${spring.oauth.scope_write}")
	private String scopeWrite;
	
	@Value("${spring.oauth.scope_trust}")
	private String scopeTrust;
	
	@Value("${spring.oauth.signingKey}")
	private String signingKey;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(signingKey);
		return converter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		configurer
				.inMemory()
				.withClient(clientId)
				.secret(clientSecret)
				.authorizedGrantTypes(grantTypePassword, authorizationCode, refreshToken, implicit )
				.scopes(scopeRead, scopeWrite, scopeTrust).accessTokenValiditySeconds(180);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        endpoints
                /*.pathMapping("/oauth/token", "/users/user/login")*/.tokenStore(tokenStore())
				.authenticationManager(authenticationManager)
				.accessTokenConverter(accessTokenConverter());
	}


}
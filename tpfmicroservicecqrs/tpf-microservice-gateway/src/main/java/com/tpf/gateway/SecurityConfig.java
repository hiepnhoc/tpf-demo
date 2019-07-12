package com.tpf.gateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(-10)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		        .antMatchers(HttpMethod.GET, "/static/**", "/templates/**","/templates/**/**").permitAll()
		        .antMatchers("/myService/***").permitAll()
		        .anyRequest().authenticated();
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring()
      .antMatchers("/scripts/**/*.{js,html}")
      .antMatchers("/bower_components/**")
      .antMatchers("/i18n/**")
      .antMatchers("/assets/**")
      .antMatchers("/swagger-ui/index.html")
      .antMatchers("/test/**")
      .antMatchers("/templates/**")
      .antMatchers("/templates/**/*.{js,html}")
      .antMatchers("/templates/**/**/*.{js,html}");
    }

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("root").password("password").roles("USER");
	}

}

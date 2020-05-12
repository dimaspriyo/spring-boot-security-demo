package com.dimaspriyo.springbootsecuritydemo.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
			.antMatchers("/adminpage").hasRole("ADMIN")
			.antMatchers("/USER").hasRole("USER")
			.and()
		.formLogin()
			.loginPage("/").permitAll()
			.and()
		.logout()
			.permitAll();
				
				
		
	}
	
}

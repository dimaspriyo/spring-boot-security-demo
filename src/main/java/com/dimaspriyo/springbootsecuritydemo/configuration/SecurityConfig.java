package com.dimaspriyo.springbootsecuritydemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/","/bootstrap/**","/allroles").permitAll()
		.antMatchers("/home/admin").hasRole("ADMIN")
		.antMatchers("/home/user").hasRole("USER")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/home")
		.and()
		.logout().permitAll()
		.logoutSuccessUrl("/login");
		
	}
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		UserDetails user =
				 User.withDefaultPasswordEncoder()
					.username("user")
					.password("userpass")
					.roles("USER")
					.build();
		
		UserDetails admin =
				 User.withDefaultPasswordEncoder()
					.username("admin")
					.password("adminpass")
					.roles("ADMIN")
					.build();
		
		return new InMemoryUserDetailsManager(user,admin);
		
	}
	
	
}

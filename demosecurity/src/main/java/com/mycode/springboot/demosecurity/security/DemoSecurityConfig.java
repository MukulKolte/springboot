package com.mycode.springboot.demosecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	/*
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails mukul = User.builder()
									.username("mukul")
									.password("{noop}test123")
									.roles("EMPLOYEE")
									.build();
		
		UserDetails pranil = User.builder()
				.username("pranil")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();
		
		UserDetails chirag = User.builder()
				.username("chirag")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
	
	return new InMemoryUserDetailsManager(mukul, pranil, chirag);
	}
	*/
	
	
	//add support for jdbc... no more hardcoded users
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		//define a query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?");
		
		//define a query to retrieve the authorities/roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id, role from roles where user_id=?");
		
		return jdbcUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer -> 
					configurer
								.requestMatchers("/").hasRole("EMPLOYEE")
								.requestMatchers("/leaders/**").hasRole("MANAGER")
								.requestMatchers("/systems/**").hasRole("ADMIN")
								.anyRequest().authenticated())
								.formLogin(form -> 
										form 
											.loginPage("/showMyLoginPage")
											.loginProcessingUrl("/authenticateTheUser")
											.permitAll()
											)
								.logout(var -> var.permitAll())
								.exceptionHandling(configurer -> 
								configurer.accessDeniedPage("/access-denied"));
							
		
		return http.build();
	}

}
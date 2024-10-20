package com.luv2code.springboot.cruddemo.security;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	//add support for JDBC... No more hardcoded users :-)
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
	
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		//define query to retrieve an user by username
		
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?");	
		
		//define query to retrieve the authorities/roles by username
		
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id, role from roles where user_id=?");
		
		return jdbcUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeHttpRequests(configurer -> 
		configurer
				.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
				
		);
		
		//use HTTP basic authentication
		httpSecurity.httpBasic(Customizer.withDefaults());
		
		//disable Cross Site Request Forgery (CSRF)
		//in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
		httpSecurity.csrf(csrf-> csrf.disable());
		
		return httpSecurity.build();
	}
	
	/*	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails mukul = User.builder()	
				.username("mukul")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails chirag = User.builder()	
				.username("chirag")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();
		
		UserDetails pranil = User.builder()	
				.username("pranil")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(mukul, chirag, pranil);
	}
*/	
}

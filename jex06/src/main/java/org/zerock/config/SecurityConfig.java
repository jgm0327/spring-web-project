package org.zerock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig {

	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/sample/all").permitAll()
		.antMatchers("/sample/member").hasRole("ROLE_MEMBER")
		.antMatchers("/sample/admin").hasRole("ROLE_ADMIN");
		
		return http.build();
	}
}

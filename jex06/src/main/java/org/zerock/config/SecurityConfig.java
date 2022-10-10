package org.zerock.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.zerock.security.CustomLoginSuccessHandler;

import lombok.extern.log4j.Log4j;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * PasswordEncoderFactories.createDelegatingPasswordEncoder(); }
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/sample/all").permitAll()
		.antMatchers("/sample/member").hasRole("MEMBER")
		.antMatchers("/sample/admin").hasRole("ADMIN");
		
		http.formLogin().loginPage("/customLogin").loginProcessingUrl("/login")
		.successHandler(loginSuccessHandler());
		
		http.logout()
		.logoutUrl("/customLogout")
		.invalidateHttpSession(true)
		.deleteCookies("remember-me", "JSESSION_ID");
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		log.info("configure.........................................");
		List<UserDetails> users = new ArrayList<UserDetails>();
		users.add(User.builder().passwordEncoder(passwordEncoder::encode)
				.username("member").password("member").roles("MEMBER").build());
		users.add(User.builder().passwordEncoder(passwordEncoder::encode)
				.username("admin").password("admin").roles("ADMIN").build());
		return new InMemoryUserDetailsManager(users);
	}
}

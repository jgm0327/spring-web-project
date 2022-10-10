package org.zerock.security.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Getter;

@Getter
public class UserVO {

	private String username;
	private String password;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public String encodedPassword(String rasPassword) {
		return encoder.encode(rasPassword); 
	}
}

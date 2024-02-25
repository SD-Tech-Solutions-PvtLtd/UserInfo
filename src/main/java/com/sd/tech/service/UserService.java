package com.sd.tech.service;

import org.springframework.http.ResponseEntity;

import com.sd.tech.entity.UserInfo;


public interface UserService {
	
	 ResponseEntity<UserInfo> saveUser(UserInfo userInfo);
	
	 ResponseEntity<UserInfo>  getByUserName(String name);
	 
	 ResponseEntity<UserInfo>  getUserById(int userid);
}

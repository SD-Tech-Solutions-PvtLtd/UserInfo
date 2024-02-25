package com.sd.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sd.tech.entity.UserInfo;
import com.sd.tech.service.UserService;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
	
	@Autowired
	private UserService userService;
	
	 ResponseEntity<UserInfo> savedUserInfo;
	 ResponseEntity<UserInfo>  userInfo;
	
	

	@PostMapping("/save")
	public ResponseEntity<UserInfo> saveUserInfo(@RequestBody UserInfo userInfo)
	{
		try
		{
			savedUserInfo = userService.saveUser(userInfo);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return savedUserInfo;
		
	}


	@GetMapping("/findByName")
	public ResponseEntity<UserInfo> getByNameUserInfo(@RequestParam String name)
	{
		try
		{
			userInfo= userService.getByUserName(name);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return userInfo;
		
	}
	
	

	@GetMapping("/fetchUserById/{userid}")
	public ResponseEntity<UserInfo> getByNameUserInfo(@PathVariable Integer userid)
	{
		try
		{
			userInfo= userService.getUserById(userid);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return userInfo;
		
	}
}

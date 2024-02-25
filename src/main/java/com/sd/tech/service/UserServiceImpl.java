package com.sd.tech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sd.tech.entity.UserInfo;
import com.sd.tech.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public  ResponseEntity<UserInfo> saveUser(UserInfo userInfo) {
	
		if(userInfo!=null)
		{
			 UserInfo savedUserInfo = userRepo.saveAndFlush(userInfo);
			 return new ResponseEntity<>(savedUserInfo, org.springframework.http.HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(null, org.springframework.http.HttpStatus.BAD_REQUEST);
		}
	 
	}

	@Override
	public ResponseEntity<UserInfo> getByUserName(String name) {
		
			 UserInfo userData = userRepo.findByUserName(name);
			 if(userData!=null)
			 {
				 return new ResponseEntity<>(userData, org.springframework.http.HttpStatus.FOUND);

			 }
		else
		{
			return new ResponseEntity<>(null, org.springframework.http.HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<UserInfo> getUserById(int userid) {
		 Optional<UserInfo> findById = userRepo.findById(userid);
		 UserInfo userData = findById.get();
		 if(userData!=null)
		 {
			 return new ResponseEntity<>(userData, org.springframework.http.HttpStatus.FOUND);

		 }
	else
	{
		return new ResponseEntity<>(null, org.springframework.http.HttpStatus.NOT_FOUND);
	}
	}

}

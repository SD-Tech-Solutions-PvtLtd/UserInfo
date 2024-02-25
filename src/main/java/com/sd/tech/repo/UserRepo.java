package com.sd.tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sd.tech.entity.UserInfo;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Integer> 
{
	UserInfo findByUserName(String name);
	  
	
}

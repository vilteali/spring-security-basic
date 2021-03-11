package com.ali.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ali.springsecurity.entity.User;
import com.ali.springsecurity.model.CRMUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);
	
	void save(CRMUser crmUser);
	
}

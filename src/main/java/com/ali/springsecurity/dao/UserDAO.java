package com.ali.springsecurity.dao;

import com.ali.springsecurity.entity.User;
import com.ali.springsecurity.model.CRMUser;

public interface UserDAO {

	User findByUserName(String userName);
	
	void save(User user);
	
}

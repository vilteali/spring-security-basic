package com.ali.springsecurity.dao;

import com.ali.springsecurity.entity.Role;

public interface RoleDAO {

	Role findRoleByName(String roleName);
	
}

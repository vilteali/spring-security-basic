package com.ali.springsecurity.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ali.springsecurity.dao.RoleDAO;
import com.ali.springsecurity.dao.UserDAO;
import com.ali.springsecurity.entity.Role;
import com.ali.springsecurity.entity.User;
import com.ali.springsecurity.model.CRMUser;

public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public User findByUserName(String userName) {
		
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(CRMUser crmUser) {
		
		User user = new User();
		
		user.setUserName(crmUser.getUsername());
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());
		user.setPassword(passwordEnconder.encode(crmUser.getPassword()));
		
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_EMPLOYEE")));
		userDao.save(user);
		
	}

}

package com.ali.springsecurity.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ali.springsecurity.entity.Role;

@Repository
public class RoleDAOManager implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Role findRoleByName(String roleName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Role role = null;
		
		try { 
			role = currentSession.createQuery("from Role where name=:roleName",
					Role.class).getSingleResult();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return role;
	}

}

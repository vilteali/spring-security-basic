package com.ali.springsecurity.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ali.springsecurity.entity.User;

@Repository
public class UserDAOManager implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findByUserName(String userName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		User user = null;
		
		try {
			user = currentSession.createQuery("from User where userName=:uName", 
					User.class).getSingleResult();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void save(User user) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
		
	}

}

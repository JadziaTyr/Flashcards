package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository // says I am a BEAN && I will contact the database
@Component("dao")
public class DAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<User> retrieveUserByUsernameAndPassword(User user)
	{
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
		        .add(Restrictions.eq("username", user.getUsername()))
		        .add(Restrictions.eq("password", user.getPassword())).list();
	}
	
	public List<User> retrieveUserByEmail(User user)
	{
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
		        .add(Restrictions.eq("email", user.getEmail())).list();
	}
	
	public void insertUser(User user)
	{
		sessionFactory.getCurrentSession().save(user);
	}
	
}
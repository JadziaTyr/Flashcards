package com.revature.transactions;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.revature.dao.DAO;
import com.revature.models.User;

@Component("transactions")
@Transactional
public class Transactions {

	@Autowired
	DAO dao;
	
	public User fetchUserByUsernameAndPassword(User user)
	{
		List<User> list = dao.retrieveUserByUsernameAndPassword(user);
		
		if(list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}
	
	public User fetchUserByEmail(User user)
	{
		List<User> list = dao.retrieveUserByEmail(user);
		
		if(list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	public boolean createUser(User user) 
	{
		dao.insertUser(user);
		
		return true;
	}
}

package org.przemo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.przemo.dao.UserDao;
import org.przemo.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl implements UserDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	protected Session currentSession() 
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(User user) 
	{
		currentSession().save(user);
	}

	@Override
	public void update(User user) 
	{
		currentSession().update(user);
	}

	@Override
	public User edit(Long userId) 
	{
		return find(userId);
	}

	@Override
	public void delete(Long userId) 
	{
		currentSession().delete(userId);
	}

	@Override
	public User find(Long userId) 
	{
		return (User)currentSession().get(User.class, userId);
	}

	@Override
	public List<User> getAll()
	{
		return currentSession().createCriteria(User.class).list();
	}

}

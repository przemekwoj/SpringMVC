package org.przemo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.przemo.dao.ForumDao;
import org.przemo.database.Forum;
import org.przemo.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("forumDao")
public class ForumDaoImpl implements ForumDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	
	protected Session currentSession() 
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(Forum forum) 
	{
		currentSession().save(forum);
	}

	@Override
	public void update(Forum forum) 
	{
		currentSession().update(forum);
	}

	@Override
	public Forum edit(Long forumId) 
	{
		
		return find(forumId);
	}

	@Override
	public void delete(Long forumId) 
	{
		currentSession().delete(forumId);
	}

	@Override
	public Forum find(Long forumId) 
	{
		return (Forum)currentSession().get(Forum.class, forumId);
	}

	@Override
	public List<Forum> getAll() 
	{
		return currentSession().createCriteria(Forum.class).list();
	}

}

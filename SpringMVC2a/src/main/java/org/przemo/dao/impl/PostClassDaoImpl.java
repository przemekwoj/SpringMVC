package org.przemo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.przemo.database.PostClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.przemo.dao.PostClassDao;
import org.przemo.dao.UserDao;
import org.przemo.database.User;


@Repository("postclassDao")
public class PostClassDaoImpl implements PostClassDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	protected Session currentSession() 
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(PostClass postclass) 
	{
		currentSession().save(postclass);
	}

	@Override
	public void update(PostClass postclass) 
	{
		currentSession().update(postclass);
	}

	@Override
	public PostClass edit(Long postclassId) 
	{
		return find(postclassId);
	}

	@Override
	public void delete(Long postclassId) 
	{
		currentSession().delete(postclassId);
	}

	@Override
	public PostClass find(Long postclassId) 
	{
		return (PostClass)currentSession().get(PostClass.class, postclassId);
	}

	@Override
	public List<PostClass> getAll()
	{
		return currentSession().createCriteria(PostClass.class).list();
	}
}

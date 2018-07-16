package org.przemo.service.impl;

import java.util.List;

import org.przemo.dao.ForumDao;
import org.przemo.dao.UserDao;
import org.przemo.database.Forum;
import org.przemo.database.User;
import org.przemo.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("forumService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor=Exception.class)

public class ForumServiceImpl implements ForumService
{

	@Autowired
	ForumDao forumDao;
	
	@Override
	public void create(Forum forum) 
	{
		forumDao.create(forum);
	}

	@Override
	public void update(Forum forum) 
	{
		forumDao.update(forum);
	}

	@Override
	public Forum edit(Long forumId)
	{
		return forumDao.edit(forumId);
	}

	@Override
	public void delete(Long forumId) 
	{
		forumDao.delete(forumId);
	}

	@Override
	public Forum find(Long forumId) 
	{
		return forumDao.find(forumId);
	}

	@Override
	public List<Forum> getAll() 
	{
		return forumDao.getAll();
	}
}

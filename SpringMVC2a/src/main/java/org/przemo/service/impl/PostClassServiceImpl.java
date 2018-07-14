package org.przemo.service.impl;

import java.util.List;

import org.przemo.dao.PostClassDao;
import org.przemo.dao.UserDao;
import org.przemo.database.PostClass;
import org.przemo.database.User;
import org.przemo.service.PostClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("postclassService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor=Exception.class)
public class PostClassServiceImpl implements PostClassService
{
	@Autowired
	PostClassDao postclassDao;
	
	@Override
	public void create(PostClass postclass) 
	{
		postclassDao.create(postclass);
	}

	@Override
	public void update(PostClass postclass) 
	{
		postclassDao.update(postclass);
	}

	@Override
	public PostClass edit(Long postclassId)
	{
		return postclassDao.edit(postclassId);
	}

	@Override
	public void delete(Long postclassId) 
	{
		postclassDao.delete(postclassId);
	}

	@Override
	public PostClass find(Long postclassId) 
	{
		return postclassDao.find(postclassId);
	}

	@Override
	public List<PostClass> getAll() 
	{
		return postclassDao.getAll();
	}
}

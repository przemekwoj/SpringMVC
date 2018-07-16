package org.przemo.service;

import java.util.List;

import org.przemo.database.Forum;


public interface ForumService 
{
	public void create(Forum forum);
	public void update(Forum forum);
	public Forum edit(Long forumId);
	public void delete(Long forumId);
	public Forum find(Long forumId);
	public List<Forum> getAll();
}

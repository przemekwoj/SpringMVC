package org.przemo.service;

import java.util.List;

import org.przemo.database.PostClass;


public interface PostClassService 
{
	public void create(PostClass postclass);
	public void update(PostClass postclass);
	public PostClass edit(Long postId);
	public void delete(Long postId);
	public PostClass find(Long postId);
	public List<PostClass> getAll();
}

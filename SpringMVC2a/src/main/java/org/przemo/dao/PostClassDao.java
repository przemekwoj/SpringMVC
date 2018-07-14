package org.przemo.dao;

import java.util.List;

import org.przemo.database.PostClass;



public interface PostClassDao 
{
	public void create(PostClass postclass);
	public void update(PostClass postclass);
	public PostClass edit(Long postclassId);
	public void delete(Long postclassId);
	public PostClass find(Long postclassId);
	public List<PostClass> getAll();
}

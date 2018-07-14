package org.przemo.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class PostClass 
{
	@Id
	@GeneratedValue
	private long postId;
	private long userId;
	private	String content;
	
	public PostClass( long userId, String content) {
		super();
		this.userId = userId;
		this.content = content;
	}
	public long getPostId() 
	{
		return postId;
	}
	public void setPostId(int postId) 
	{
		this.postId = postId;
	}
	public long getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getContent() 
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	
}

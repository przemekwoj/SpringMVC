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
	private String forumname;
	
	public PostClass() 
	{
		postId =0;
		userId =0;
		content = "iam in default Post   cass constructor";
		forumname = "";
	}
	public String getForumname() {
		return forumname;
	}
	public void setForumId(String forumname) {
		this.forumname = forumname;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public PostClass( long userId, String content,String forumname) {
		super();
		this.userId = userId;
		this.content = content;
		this.forumname = forumname;
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

package org.przemo.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Forum 
{
	@Id
	@GeneratedValue
	private long forumId;
	private String nazwa;
	private String link;
	private String namepage;
	
	public long getForumId()
	{
		return forumId;
	}
	public void setForumId(long forumId) 
	{
		this.forumId = forumId;
	}
	public String getNazwa()
	{
		return nazwa;
	}
	public void setNazwa(String nazwa)
	{
		this.nazwa = nazwa;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link)
	{
		this.link = link;
	}
	public String getNamepage() 
	{
		return namepage;
	}
	public void setNamePage(String namepage) 
	{
		this.namepage = namepage;
	}
	
}

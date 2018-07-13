package org.przemo.database;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.przemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class User 
{	
	
	@Id
	@GeneratedValue
	private long userId;
	private String name;
	private String surname;
	private String email;
	private String phone;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean checknull()
	{
		if(name=="")
		{
			return false;
		}
		else if(surname == "")
		{
				return false;
		}
		else if(email == "")
		{
				return false;
		}
		else if(phone == "")
		{
				return false;
		}
		else return true;
	}
	
	public boolean checklogin(List<User> list, String n,String s, String e)
	{
	
		
		boolean checked = false;
		for(User u :list)
		{
			if(u.getEmail().equals(e) & u.getName().equals(n) & u.getSurname().equals(s))
			{
				checked= true;;
			}
		}
		return checked;	
	}
	
}

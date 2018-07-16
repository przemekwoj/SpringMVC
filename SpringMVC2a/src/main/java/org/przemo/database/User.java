package org.przemo.database;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import org.przemo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;

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
	
	
	public long getuserId() {
		return userId;
	}
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
		System.out.println(n);
		System.out.println(s);
		System.out.println(e);
		System.out.println(list.size());

		boolean checked = false;
		System.out.println("iam here0:)");

		for(User u :list)
		{
			System.out.println("iam here:)");
			System.out.println(u.getEmail()+" "+u.getName()+" "+u.getSurname());
			System.out.println(u.getEmail().equals(e)+" "+u.getName().equals(n)+" "+u.getSurname().equals(s));
			if(u.getEmail().equals(e)& u.getName().equals(n) & u.getSurname().equals(s))
			{
				System.out.println("iam here7:)");
				checked= true;
				break;
			}
		}
		System.out.println("iam here3:)");
		return checked;	
	}
	
}

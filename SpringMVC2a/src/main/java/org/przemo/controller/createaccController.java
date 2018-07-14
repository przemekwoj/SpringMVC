package org.przemo.controller;

import java.util.List;
import java.util.Map;

import org.przemo.database.User;
import org.przemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class createaccController 
{
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/createacc" ,method=RequestMethod.POST)
	public String createUser(User user, ModelMap map)
	{
		boolean toCreateAcc = true;
		String page="firstpage";
		List<User> list = userService.getAll();
		for(User u: list)
		{
			if(user.checknull() == false)
			{
				map.addAttribute("info","You have missed pool to fill");
				page="createacc";
				toCreateAcc = false;
				break;
			}
			if(user.getEmail().equals(u.getEmail()))
			{
				map.addAttribute("info","This email is already exist, please try diffrent email");
				page="createacc";
				toCreateAcc = false;
				break;
			}
		}
		if(toCreateAcc == true)
		{
		userService.create(user);
		}
		return page;
		
		
	}
}

package org.przemo.controller;


import java.util.List;
import java.util.Map;

import org.przemo.database.User;
import org.przemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController 
{
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/log" ,method=RequestMethod.GET)
	public String log()
	{
		return "loginpage";
	}
	
	@RequestMapping(value="/firstpage" ,params ="createaccount" ,method=RequestMethod.POST)
	public String createacc()
	{
		return "createacc";
	}
	
	@RequestMapping(value="/firstpage" ,params ="login" ,method=RequestMethod.POST)
	public String login(@RequestParam(value="name") String name, 
			@RequestParam(value="surname") String surname,
			@RequestParam(value="email") String email,
			Map<String,Object> map)
	{
		String page ="firstpage";
		List<User> list = userService.getAll();
		boolean checked;
		User user = new User();
		checked = user.checklogin(list, name, surname, email);
		if(checked == false)
		{
			map.put("info", "you used wrong email or password , please try again");
			page = "loginpage";
		}
		return page;
	}

}

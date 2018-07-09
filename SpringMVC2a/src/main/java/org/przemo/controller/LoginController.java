package org.przemo.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController 
{
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
	//powinny byc w klasie user takie same nazwy zmiennych jak inputy w jsp
	public String login(User user, Map<String,Object> map)
	{
		map.put("name", user.getName());
		map.put("surname", user.getSurname());
		map.put("email",user.getEmail());
		//// tutaj kod sprawdzajacy czy jest w bazie danych taki
		return "firstpage";
	}

}

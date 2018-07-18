package org.przemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.przemo.dao.PostClassDao;
import org.przemo.database.Forum;
import org.przemo.database.PostClass;
import org.przemo.database.User;
import org.przemo.service.ForumService;
import org.przemo.service.PostClassService;
import org.przemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(value = {"name","surname","email","namepage","subject"})
public class LogoutController 
{

	@RequestMapping(value="/addInscription" ,params ="logout",method=RequestMethod.POST)
	public String log(Map<String,Object> map)
	{
		map.put("name", "");
		map.put("surname", "");
		map.put("email", "");
		return "loginpage";
	}
}

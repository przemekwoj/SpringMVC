package org.przemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.przemo.database.PostClass;
import org.przemo.database.User;
import org.przemo.service.PostClassService;
import org.przemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes(value = {"name","surname","email"})
public class createaccController 
{
	@Autowired
	UserService userService;
	@Autowired
	PostClassService postclassDao;
	
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
			map.put("name", user.getName());
			map.put("surname", user.getSurname());
			map.put("email", user.getEmail());
			List<String> lists = new ArrayList();
			lists = addcontent(map);
			map.put("lists", lists);
			userService.create(user);
		}
	return page;
	}
	
	public List<String> addcontent(Map<String,Object> map)
	{
		List<String> list = new ArrayList<String>();
		List<PostClass> l = postclassDao.getAll();
		for(PostClass p : l)
		{
			list.add(userService.find(p.getUserId()).getEmail() +":   "+p.getContent());
		}
		map.put("lists", list);
		return list;
	}
}

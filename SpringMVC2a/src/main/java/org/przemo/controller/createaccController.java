package org.przemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.przemo.database.Forum;
import org.przemo.database.PostClass;
import org.przemo.database.User;
import org.przemo.service.ForumService;
import org.przemo.service.PostClassService;
import org.przemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes(value = {"name","surname","email","subject"})
public class createaccController 
{
	@Autowired
	UserService userService;
	@Autowired
	PostClassService postclassDao;
	@Autowired
	ForumService forumDao;
	
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
			map.put("subject", "welcome");
			List<String> lists2 = new ArrayList();
			lists2 = addforum(map);
			map.put("lists2", lists2);
			userService.create(user);
		}
	return page;
	}
	
	public List<String> addforum(Map<String,Object> map)
	{
		List<String> list2 = new ArrayList<String>();
		List<Forum> l2 = forumDao.getAll();
		for(Forum f : l2)
		{
			list2.add(f.getNazwa());
		}
		map.put("lists2", list2);
		return list2;
	}
}

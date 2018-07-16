package org.przemo.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.przemo.dao.ForumDao;
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
public class LoginController 
{
	@Autowired
	UserService userService;
	@Autowired
	PostClassService postclassDao;
	@Autowired
	ForumService forumDao;
	
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
		map.put("name",name);
		map.put("surname",surname);
		map.put("email",email);
		map.put("namepage","firstpage");
		map.put("subject","welcome");
		checked = user.checklogin(list, name, surname, email);
		System.out.println("5");
		
		List<String> lists = new ArrayList();
		List<String> lists2 = new ArrayList();
		lists = addcontent(map,page);
		map.put("lists", lists);
		lists2 = addforum(map);
		map.put("lists2", lists2);
		if(checked == false)
		{
			map.put("info", "you used wrong email or password , please try again");
			page = "loginpage";
		}
		return page;
	}
	
	public List<String> addcontent(Map<String,Object> map,String page)
	{
		List<String> list = new ArrayList<String>();
		List<PostClass> l = postclassDao.getAll();
		for(PostClass p : l)
		{
			if(p.getForumname().equals(page))
			{
			list.add(userService.find(p.getUserId()).getEmail() +":   "+p.getContent());
			}
		}
		map.put("lists", list);
		return list;
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

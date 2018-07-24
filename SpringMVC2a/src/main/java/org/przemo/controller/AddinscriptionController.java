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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"name","surname","email","namepage","subject"})
public class AddinscriptionController
{				
	@Autowired
	PostClassService postclassDao;
	@Autowired
	UserService userService;
	@Autowired
	ForumService forumDao;
	
	@RequestMapping(value="/addInscription" ,method=RequestMethod.POST)
	public String log(@RequestParam(value = "content") String content,Map<String,Object> map)
	{
		long userId = 0;
		String email = map.get("email").toString();
		////pobieranie Id usera
		List<User> list = userService.getAll();
		List<String> postlist = new ArrayList<String>();
		for(User u: list)
		{
			if(email.equals(u.getEmail()))
			{
				userId = u.getuserId();
				break;
			}
		}
		//tworzenie posta w bazie danych
		PostClass post = new PostClass(userId,content,(String)map.get("namepage"));
		postclassDao.create(post);
		///pobieranie postow
		List<PostClass> l = postclassDao.getAll();
		for(PostClass p : l)
		{
			if(p.getContent()!=null & p.getForumname()!=null)
			{
				System.out.println(p.getForumname());
				System.out.println((String)map.get("namepage"));
				if(((String)map.get("namepage")).equals(p.getForumname()))
				{
					postlist.add(userService.find(p.getUserId()).getEmail() +":   "+p.getContent());
				}
			}
		}
		map.put("lists", postlist);
		map.put("lists2", addforum(map));
		return "firstpage";
	}
	
	@RequestMapping(value="/looseSearch",method=RequestMethod.GET)
	public @ResponseBody List<String> ret(Map<String,Object> map)
	{
		List<String> postlist = new ArrayList<String>();
		List<PostClass> l = postclassDao.getAll();
		for(PostClass p : l)
		{
			if(p.getContent()!=null & p.getForumname()!=null)
			{
				if(((String)map.get("namepage")).equals(p.getForumname()))
				{
					postlist.add(userService.find(p.getUserId()).getEmail() +":   "+p.getContent());
				}
			}
		}
	    return postlist;
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

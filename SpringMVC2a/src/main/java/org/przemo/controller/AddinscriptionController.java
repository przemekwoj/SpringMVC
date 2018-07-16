package org.przemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.przemo.dao.PostClassDao;
import org.przemo.database.PostClass;
import org.przemo.database.User;
import org.przemo.service.PostClassService;
import org.przemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"name","surname","email"})
public class AddinscriptionController
{				
	@Autowired
	PostClassService postclassDao;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/addInscription" ,method=RequestMethod.POST)
	public String log(@RequestParam(value = "content") String content,Map<String,Object> map)
	{
		long userId = 0;
		String email = map.get("email").toString();
		////pobieranie Id usera
		List<User> list = userService.getAll();
		List<String> postlist = new ArrayList<String>();
		User user = new User();
		for(User u: list)
		{
			if(email.equals(u.getEmail()))
			{
				userId = u.getuserId();
				break;
			}
		}
		//tworzenie posta w bazie danych
		PostClass post = new PostClass(userId,content);
		postclassDao.create(post);
		///pobieranie postow
		List<PostClass> l = postclassDao.getAll();
		for(PostClass p : l)
		{
			//user = userService.find((long)15);
			//System.out.println(p.getUserId());
			//System.out.println(user.getEmail());
			//System.out.println(user.getuserId());
			//System.out.println("wytyfyy");

			user = userService.find(p.getUserId());
			postlist.add(userService.find(p.getUserId()).getEmail() +":   "+p.getContent());
		}
		map.put("lists", postlist);
		return "firstpage";
	}
}

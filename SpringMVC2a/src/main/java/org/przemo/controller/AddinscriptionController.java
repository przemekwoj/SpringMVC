package org.przemo.controller;

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
		System.out.println("iam here000000000000000000000");
		long userId = 0;
		String email = map.get("email").toString();
		////pobieranie Id usera
		List<User> list = userService.getAll();
		System.out.println("iam here00000000000000000000aaaaaaaaaaaaaa0");
		for(User u: list)
		{
			if(email.equals(u.getEmail()))
			{
				userId = u.getuserId();
				break;
			}
		}
		//tworzenie posta w bazie danych
		PostClass post = new PostClass(4,content);
		System.out.println(userId);
		System.out.println(content);
		System.out.println(email);
		System.out.println("iam here111111");
		postclassDao.create(post);
		System.out.println("iam here222222");

		return "firstpage";
	}
}

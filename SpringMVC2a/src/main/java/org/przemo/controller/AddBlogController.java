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
public class AddBlogController 
{
	@Autowired
	PostClassService postclassDao;
	@Autowired
	UserService userService;
	@Autowired
	ForumService forumDao;
	
	
	//dodaje bloga ta funckja
	@RequestMapping(value="/addblog" ,params="addblog",method=RequestMethod.POST)
	public String addblog(@RequestParam(value="nameblog") String nameblog,Map<String,Object> map)
	{	
		List<Forum> listforum = forumDao.getAll();
		String page = "firstpage";
		
		for(Forum f: listforum)
		{
			if(f.getNazwa().equals(nameblog))
			{
				map.put("info", "this subject is alredy exist, check our page");
				page = "addForum";
				break;
			}
			else
			{
				//ustawia parametry dla bazy danych i tworzy obiekt w bazie danych
				map.put("subject", nameblog);
				map.put("namepage", nameblog);
				Forum forum = new Forum();
				forum.setLink(nameblog);
				forum.setNamePage(nameblog);
				forum.setNazwa(nameblog);
				forumDao.create(forum);
				break;
			}
		}
		/// te listy zwracaja co ma wyswielic firstpage.jsp
		List<String> lists = new ArrayList();
		List<String> lists2 = new ArrayList();
		lists = addcontent(map,page);
		map.put("lists", lists);
		lists2 = addforum(map);
		map.put("lists2", lists2);
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

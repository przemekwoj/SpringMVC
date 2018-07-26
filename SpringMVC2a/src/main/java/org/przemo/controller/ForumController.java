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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@SessionAttributes(value = {"name","surname","email","namepage","subject"})
public class ForumController 
{
	@Autowired
	PostClassService postclassDao;
	@Autowired
	UserService userService;
	@Autowired
	ForumService forumDao;
	
	// funkcja wybiera forum jakie jest wyswietlane aktualnie na stronie
	@RequestMapping(value="/forum/{argument}",method=RequestMethod.GET)
	public String returnpage(@PathVariable("argument") String argument,Map<String,Object> map)
	{
		// ten if zabezpiecza przed zlym wplywem AJAX , bo asynchdonicznie wywoluje argument looseSearch , co
		//psuje wsyzstko
		if(!argument.equals("looseSearch"))
				{
				map.put("namepage",argument);
				map.put("subject", argument);
				
		List<PostClass> l = postclassDao.getAll();
		List<String> postlist = new ArrayList<String>();
		/// bierze odpowiednie komentarze z bazy danych do danego tematu na forum
		for(PostClass p : l)
		{
			if(((String)map.get("namepage")).equals(p.getForumname()))
			{
			postlist.add(userService.find(p.getUserId()).getEmail() +":   "+p.getContent());
			}
		}
		map.put("lists", postlist);
		map.put("lists2", addforum(map));
				}
	    return "firstpage";
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

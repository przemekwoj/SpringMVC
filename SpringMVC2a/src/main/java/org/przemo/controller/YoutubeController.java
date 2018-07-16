package org.przemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.przemo.database.PostClass;
import org.przemo.database.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class YoutubeController 
{
	@RequestMapping(value="/youtube" ,method=RequestMethod.GET)
	public RedirectView youtube()
	{
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("http://www.youtube.com");
	    return redirectView;
	}
}


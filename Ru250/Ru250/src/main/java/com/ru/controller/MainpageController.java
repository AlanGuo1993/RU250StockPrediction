package com.ru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainpageController {
	
	@RequestMapping("/")
	public String indexMapping()
	{
		return "mainpage";
	}
	
	@RequestMapping(value = "/login_admin", method = RequestMethod.GET)
    public String newPage(Model model) {
        return "login_admin";
    }
	
	@RequestMapping(value = "/mainpage_login_admin", method = RequestMethod.GET)
    public String mainpageAdmin(Model model) {
        return "mainpage_login_admin";
    }
	
	@RequestMapping(value = "/mainpage_login", method = RequestMethod.GET)
    public String mainpage(Model model) {
        return "mainpage_login";
    }
	
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String aboutUs(Model model) {
        return "aboutus";
    }
	
	@RequestMapping(value = "/include", method = RequestMethod.GET)
    public String include(Model model) {
        return "include";
    }
}

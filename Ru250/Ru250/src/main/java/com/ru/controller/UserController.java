package com.ru.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ru.commons.MD5;
import com.ru.entity.Person;
import com.ru.entity.User;
import com.ru.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    
	//Register
	@RequestMapping(value= "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("userinfo") User u,HttpServletRequest request){
		
    	String userName = request.getParameter("userName");
    	String email = request.getParameter("email");
    	String pwd = request.getParameter("pwd");
    	String repwd = request.getParameter("repwd");
    	if(pwd.equals(repwd)){
	    	String newPwd = MD5.getMD5(pwd);
	    	
	    	if(userService.isUsernameExist(userName)||userService.isEmailExist(email)){
	    		return "error";
	    	}else{
	    		this.userService.addUser(userName, email, newPwd);
	    		return "redirect:/login_admin";
			}
    	}else{
    		return "error";
    	}
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	@ResponseBody
	public User login (@ModelAttribute("userinfo") User u,HttpServletRequest request, ModelMap modelMap){
		User user = new User();
		String userName = request.getParameter("userName");
    	String pwd = request.getParameter("pwd");
    	String newPwd = MD5.getMD5(pwd);
    	user = userService.login(userName, newPwd);
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("currentUser", user);
    	return user;
    }
	
	@RequestMapping(value= "/logout", method = RequestMethod.POST)
	public String logout (@ModelAttribute("userinfo") User u,HttpServletRequest request, ModelMap modelMap){
		User user = new User();
    	HttpSession session = request.getSession();
    	session.getAttribute("currentUser");
    	session.removeAttribute("currentUser");
		return "index";
	
	}

}

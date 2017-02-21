package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.models.User;
import com.revature.services.Service;

@Controller

public class LoginController
{
	@Autowired
	Service service;
	
	@RequestMapping(value = "/")
	public String loginInitial(ModelMap map)
	{
		User user = new User();
		map.addAttribute("user", user); // request scope
		System.out.println("login catch all method");
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login")
	public String loginCatechAll(ModelMap map)
	{
		User user = new User();
		map.addAttribute("user", user); // request scope
		System.out.println("login catch all method");
		return "Login";
	}
	
	@RequestMapping(value = "/logout")
	public String logoutCatchAll(HttpSession session)
	{
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(User user, HttpSession session)
	{
		System.out.println("login Post method");
		
		System.out.println(user);
		if (service.authorizeLogin(user))
		{
			session.setAttribute("user", user);
			return "redirect:home";
		}
		return "Login";
	}
}
package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.models.User;
import com.revature.services.Service;

@Controller
public class InviteUserController
{
	@Autowired
	Service service;
	
	@RequestMapping(value = "/invite_friend")
	public String loginFriend(ModelMap map, HttpSession session)
	{
		User user = new User();
		map.addAttribute("user", user); // request scope
		return "InviteUser";
	}
	
	@RequestMapping(value = "/invite_admin")
	public String loginAdmin(ModelMap map, HttpSession session)
	{
		User user = new User();
		map.addAttribute("user", user); // request scope
		return "InviteAdministrator";
	}
	
	@RequestMapping(value = "/invite_friend", method = RequestMethod.POST)
	public String loginFriendPost(User user, ModelMap map)
	{
		boolean validCreation = service.inviteUser(user);
		
		if (validCreation)
		{
			map.addAttribute("message", "Successful Invite");
			return "InviteUser";
		}
		map.addAttribute("message", "Invite Malfunction");
		return "InviteUser";
	}
	
	@RequestMapping(value = "/invite_admin", method = RequestMethod.POST)
	public String loginAdminPost(User user, HttpServletRequest req, ModelMap map)
	{
		boolean validCreation = service.inviteUser(user);
		
		if (validCreation)
		{
			map.addAttribute("message", "Successful Invite");
			return "InviteAdministrator";
		}
		map.addAttribute("message", "Invite Malfunction");
		return "InviteAdministrator";
	}
}
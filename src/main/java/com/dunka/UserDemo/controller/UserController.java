package com.dunka.UserDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dunka.UserDemo.bean.User;
import com.dunka.UserDemo.service.UserService;
import com.dunka.UserDemo.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("/index.html");
	}
	@RequestMapping("/register.do")
	public ModelAndView register(User user) {
		System.out.println(user.getUsername()+user.getPassword()+user.getTelephone());
		userServiceImpl.save(user);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/login.do")
	public ModelAndView login(User user) {
		System.out.println(user.getUsername()+user.getPassword()+user.getTelephone());
		Boolean success = userServiceImpl.login(user);
		
		if(success==true) return new ModelAndView("/welcome.html");
		else return new ModelAndView("redirect:/");
	}
}

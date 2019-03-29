package com.dunka.UserDemo.controller;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping("/show.do")
	public ModelAndView showAllUser(Model model) {
		List<User> userList = userServiceImpl.findAll();
		model.addAttribute("userList", userList);
		return new ModelAndView("/showAllUser.html","userModel",model);
	}
	@RequestMapping("/toEdit/{id}")
	public ModelAndView edit(@PathVariable("id")Long id,Model model) {
		
		User user = userServiceImpl.findById(id);
		System.out.println(user.getUsername()+user.getPassword()+user.getTelephone());
		
		model.addAttribute("user", user);
		return new ModelAndView("/editUser.html","userModel",model);
	}
	@RequestMapping("/edit")
	public ModelAndView toEdit(User user) {
		userServiceImpl.save(user);
		System.out.println(user.getUsername()+"/"+user.getPassword()+"/"+user.getTelephone());
		return new ModelAndView("redirect:/show.do");
	}
}

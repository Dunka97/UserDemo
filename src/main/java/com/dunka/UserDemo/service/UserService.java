package com.dunka.UserDemo.service;

import java.util.List;

import org.springframework.ui.Model;

import com.dunka.UserDemo.bean.User;

public interface UserService {
	void save(User user);
	Boolean login(User user);
	List<User> findAll();
}

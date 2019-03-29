package com.dunka.UserDemo.service;

import com.dunka.UserDemo.bean.User;

public interface UserService {
	void save(User user);
	Boolean login(User user);
}

package com.dunka.UserDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dunka.UserDemo.bean.User;
import com.dunka.UserDemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public void save(User user) {
		userRepository.save(user);
	}
	public Boolean login(User user) {
	User user2 = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		return user2==null?false:true;
	}

}

package com.dunka.UserDemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.dunka.UserDemo.bean.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findUserByUsernameAndPassword(String username,String password);
}

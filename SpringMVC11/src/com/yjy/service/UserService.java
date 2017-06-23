package com.yjy.service;

import java.util.List;

import com.yjy.model.User;

public interface UserService {
	void save(User user);
	boolean update(User user);
	boolean delete(int id);
	User findById(int id);
	List<User> findAll();
}

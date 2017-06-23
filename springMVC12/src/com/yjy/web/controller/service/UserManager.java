package com.yjy.web.controller.service;

import java.util.List;

import com.yjy.web.controller.dao.IUserDAO;
import com.yjy.web.controller.entity.User;

public class UserManager implements IUserManager {
	
	private IUserDAO userDao;  //接口
	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	@Override  //添加用户
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override //得到所有用户
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override //删除用户
	public boolean delUser(String id) {
		return userDao.delUser(id);
	}

	@Override  //得到一个用户信息
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Override  //更新用户信息
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

}

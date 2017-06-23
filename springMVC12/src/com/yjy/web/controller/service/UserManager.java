package com.yjy.web.controller.service;

import java.util.List;

import com.yjy.web.controller.dao.IUserDAO;
import com.yjy.web.controller.entity.User;

public class UserManager implements IUserManager {
	
	private IUserDAO userDao;  //�ӿ�
	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	@Override  //����û�
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override //�õ������û�
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override //ɾ���û�
	public boolean delUser(String id) {
		return userDao.delUser(id);
	}

	@Override  //�õ�һ���û���Ϣ
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Override  //�����û���Ϣ
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

}

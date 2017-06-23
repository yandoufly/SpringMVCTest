package com.yjy.web.controller.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.yjy.web.controller.entity.User;

public class UserDao implements IUserDAO {
	
	private SessionFactory sessionFactory;
	//编写该set方法
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override //添加用户
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override  //得到全部用户
	public List<User> getAllUser() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override //删除用户
	public boolean delUser(String id) {
		String hql = "delete User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override //得到一个用户
	public User getUser(String id) {
		String hql = "from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0,id);
		return (User)query.uniqueResult();
	}

	@Override //更新用户信息
	public boolean updateUser(User user) {
		String hql = "update User u set u.userName=?,u.age=? where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUserName());
		query.setString(1, user.getAge());
		query.setString(2, user.getId());
		
		return (query.executeUpdate() > 0);
	}

}

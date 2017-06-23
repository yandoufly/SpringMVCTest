package com.yjy.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjy.mapper.UserMapper;
import com.yjy.model.User;
import com.yjy.service.UserService;

@Service
@Transactional  //�˴����ٽ��д���SqlSession���ύ���񣬶��ѽ���springȥ�����ˡ�
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper mapper;

	public boolean delete(int id) {
		
		return mapper.delete(id);
	}

	public List<User> findAll() {
		List<User> findAllList = mapper.findAll();
		return findAllList;
	}

	public User findById(int id) {

		User user = mapper.findById(id);
		
		return user;
	}

	public void save(User user) {

		mapper.save(user);
	}

	public boolean update(User user) {

		return mapper.update(user);
	}
	
	

}

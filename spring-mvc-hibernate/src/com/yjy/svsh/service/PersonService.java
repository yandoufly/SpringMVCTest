package com.yjy.svsh.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjy.svsh.dao.PersonDao;
import com.yjy.svsh.entity.Person;

@Service
@Transactional
public class PersonService {

	@Autowired
	public PersonDao personDao;
	
	/**
	 * 添加
	 * @param person
	 */
	public void addPerson(Person person) {
		personDao.addPerson(person);
	}
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Person getPersonById(Integer id){
		return personDao.getPersonById(id);
	}
	/**
	 * 更新
	 * @param person
	 */
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deletePersonById(Integer id) {
		personDao.deletePersonById(id);
	}
	/**
	 * 查询
	 * @return
	 */
	public List<Person> getPersons() {
		return personDao.getPersons();
	}
}

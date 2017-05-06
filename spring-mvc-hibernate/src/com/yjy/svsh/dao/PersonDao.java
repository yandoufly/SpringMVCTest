package com.yjy.svsh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.yjy.svsh.entity.Person;

@Repository
public class PersonDao {

	@Resource
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Person getPersonById(Integer id) {
		return (Person) getSession().get(Person.class, id);
	}

	/**
	 * 添加
	 * @param person
	 */
	public void addPerson(Person person) {
		this.getSession().save(person);
	}
	
	/**
	 * 更新
	 * @param person
	 */
	public void updatePerson(Person person) {
		this.getSession().update(person);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void deletePersonById(Integer id) {
		getSession().createQuery("delete Person where id=?").setParameter(0, id).executeUpdate();
	}
	
	/**
	 * 查询
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		return this.getSession().createCriteria(Person.class).list();
	}
}

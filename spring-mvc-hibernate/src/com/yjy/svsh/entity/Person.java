package com.yjy.svsh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "person")
public class Person {
	private Integer id;// 主键id
	private String name;// 姓名
	private String idCard;// 身份证号
	private String phone;// 手机
	private String address;// 地址

	public Person() {
		super();
	}

	public Person(String name, String idCard, String phone, String address) {
		super();
		this.name = name;
		this.idCard = idCard;
		this.phone = phone;
		this.address = address;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, unique = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "idCard", nullable = false, length = 32)
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "phone", nullable = false, length = 32)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	@Column(name = "address", nullable = false, length = 32)
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", idCard=" + idCard + ", phone=" + phone + ", address="
				+ address + "]";
	}

}

package com.yjy.svsh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yjy.svsh.entity.Person;
import com.yjy.svsh.service.PersonService;

@Controller    //使用该注解标志它是一个控制器
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	public PersonService personService;

	//登录请求，失败返回error.jsp
	@RequestMapping("/login")
	public String dologin(String username, String password, Map<String, Object> map) {
		if(username != null && password != null) {
			if (username.equals("admin") && password.equals("admin")) {
				return "redirect:main";
			}
		}
		return "error";
	}
	
	// 查询所有人员信息
	@RequestMapping(value = "/main")
	public String mian(Map<String, Object> map) {
		map.put("personlist", personService.getPersons());
		return "main";
	}
	
	// 保存添加的数据
	@RequestMapping(value = "/saveperson")
	public String saveperson(Person person) {
		personService.addPerson(person);
		return "redirect:main";
	}

	// 跳转到添加页面
	@RequestMapping(value = "/addperson")
	public String saveperson() {
		return "savepage";
	}

	// 删除数据
	@RequestMapping(value = "/deletePersonById")
	public String deletePersonById(@RequestParam(value = "id") Integer id) {
		personService.deletePersonById(id);
		return "redirect:main";
	}

	// 跳转到更新页面，回显数据
	@RequestMapping(value = "/doupdate")
	public String doupdate(@RequestParam(value = "id") Integer id, Model model) {
		model.addAttribute("person", personService.getPersonById(id));
		return "editpage";
	}

	// 更新数据
	@RequestMapping(value = "/updateperson")
	public String updateperson(Person person) {
		System.out.println(person.toString());
		personService.updatePerson(person);
		return "redirect:main";
	}
	
}

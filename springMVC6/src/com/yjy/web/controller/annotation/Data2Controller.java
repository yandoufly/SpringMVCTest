package com.yjy.web.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yjy.web.controller.entity.User;

@Controller  //����������
@RequestMapping("/data2")
public class Data2Controller {

	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request){
		
		request.setAttribute("username", user.getUsername());
		request.setAttribute("age", user.getAge());
		return "/userManager";
	}
	
	@RequestMapping("/delUser")
	public String delUser(){
		String result ="this is delUser------";
		return result;
	}
	
	@RequestMapping("/toUser")
	public String toUser(){
		return "addUser2";
	}
}

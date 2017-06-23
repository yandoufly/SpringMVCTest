package com.yjy.web.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller  //必须添加这个
@RequestMapping("/data")
public class DataController {

	@RequestMapping("/addUser")
	public String addUser(String username, String age, HttpServletRequest request){
		
		request.setAttribute("username", username);
		request.setAttribute("age", age);
		return "/userManager";
	}
	
	@RequestMapping("/delUser")
	public String delUser(){
		String result ="this is delUser------";
		return result;
	}
	
	@RequestMapping("/toUser")
	public String toUser(){
		return "addUser";
	}
}

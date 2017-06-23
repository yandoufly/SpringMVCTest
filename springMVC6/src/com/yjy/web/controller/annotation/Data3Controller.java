package com.yjy.web.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yjy.web.controller.entity.User;

@Controller  //必须添加这个
@RequestMapping("/data3")
public class Data3Controller {


	@RequestMapping("/addUserJson")
	public String addUserJson(String username, String age, HttpServletRequest request){
		
		request.setAttribute("username", username);
		request.setAttribute("age", age);
		return "/userManager";
	}
	
	
	@RequestMapping("/toUser")
	public String toUser(){
		return "json";
	}
}

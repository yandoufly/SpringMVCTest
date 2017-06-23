package com.yjy.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //用来标注当前类是springmvc的控制层的类
@RequestMapping("/spring") //controller的唯一标识或者命名空间
public class SpringController {
	
	@RequestMapping("/get")
	public String get(HttpServletRequest request){
		System.out.println("SpringController()...");
		String name = "微纹";
		request.setAttribute("name", name);
		return "/success";
	}
}

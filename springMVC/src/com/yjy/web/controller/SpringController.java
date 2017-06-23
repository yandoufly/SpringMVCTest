package com.yjy.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //������ע��ǰ����springmvc�Ŀ��Ʋ����
@RequestMapping("/spring") //controller��Ψһ��ʶ���������ռ�
public class SpringController {
	
	@RequestMapping("/get")
	public String get(HttpServletRequest request){
		System.out.println("SpringController()...");
		String name = "΢��";
		request.setAttribute("name", name);
		return "/success";
	}
}

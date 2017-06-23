package com.yjy.web.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjy.web.controller.entity.User;
import com.yjy.web.controller.service.IUserManager;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userManager")
	private IUserManager userManager;
	
	@RequestMapping("/toAddUser")
	public String toAddUser(){
		return "/addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user){
		
		userManager.addUser(user);
		//请求重定向
		return "redirect:/user/getAllUser";
	}
	
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		List<User> user = userManager.getAllUser();
		request.setAttribute("user", user);
		
		return "/userManager";
	}
	
	@RequestMapping("/delUser")
	public void delUser(String id, HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if(userManager.delUser(id)){
			result = "{\"result\":\"success\"}";
		}
		
		PrintWriter out = null;
		response.setContentType("application/json");
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getUser")
	public String getUser(String id,HttpServletRequest request){
		User user = userManager.getUser(id);
		
		request.setAttribute("user", user);
		return "/editUser";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(User user,HttpServletRequest request){
		
		if(userManager.updateUser(user)){
			user = userManager.getUser(user.getId());
			request.setAttribute("user", user);
			return "/success";
		}else{
			return "/error";
		}
		
	}
}

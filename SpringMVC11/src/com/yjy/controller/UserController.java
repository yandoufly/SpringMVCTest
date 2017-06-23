package com.yjy.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjy.model.User;
import com.yjy.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		
		List<User> findAll = userService.findAll();
		
		request.setAttribute("userList", findAll);
		return "/allUser";
	}
	
	@RequestMapping("/toAddUser")
	public String toAddUser(HttpServletRequest request){
		
		return "/addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user,HttpServletRequest request){
		userService.save(user);
		return "redirect:/user/getAllUser";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(User user,HttpServletRequest request){
		
		
		if(userService.update(user)){
			user = userService.findById(user.getId());
			request.setAttribute("user", user);
			return "redirect:/user/getAllUser";
		}else{
			return "/error";
		}
	}
	
	@RequestMapping("/getUser")
	public String getUser(int id,HttpServletRequest request){
		
		request.setAttribute("user", userService.findById(id));
		return "/editUser";
	}
	
	@RequestMapping("/delUser")
	public void delUser(int id,HttpServletRequest request,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		
		if(userService.delete(id)){
			result = "{\"result\":\"success\"}";
		}
		
		response.setContentType("application/json");
		
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

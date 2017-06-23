package com.yjy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjy.javabean.UserBean;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String submitFlag = request.getParameter("submitFlag");
		if("toLogin".equals(submitFlag)){
			toLogin(request, response);
			return;
		}else if("login".equals(submitFlag)){
			login(request, response);
			return;
		}
		toLogin(request, response); //默认到登录页面
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1收集参数
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	//2验证并封装参数(重复的步骤)
    	UserBean user = new UserBean();
    	user.setUsername(username);
    	user.setPassword(password);
    	//3调用javabean对象（业务方法）
    	if(user.login()) {
    		//4根据返回值选择下一个页面
    		response.getWriter().write("login success");
    	} else {
    		response.getWriter().write("login fail");
    	}
    	
	}

	private void toLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html;charset=utf-8");
		String loginPath = request.getContextPath() + "/servletLogin";
		PrintWriter out = response.getWriter();
		
		out.write("<form action='" + loginPath + "' method='post'>");
		out.write("<input type='text' name='submitFlag' value='login'/>");
		out.write("username:<input type='text' name='username'/>");
		out.write("password:<input type='password' name='password'/>");
		out.write("<input type='submit' value='login'/>");
		out.write("</form>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
}

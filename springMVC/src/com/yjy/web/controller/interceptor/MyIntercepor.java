package com.yjy.web.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//编辑拦截器
public class MyIntercepor implements HandlerInterceptor {
	//执行时机：视图已经被解析完毕,类似try catch 后的finally
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse response, Object object, Exception e)
			throws Exception {
		System.out.println("afterCompletion()...");
		if(e != null){
			System.out.println(e);  //输出异常
		}
		System.out.println("================");
	}
	
	//执行时机：controller执行完，视图解析器没有把视图解析成页面, 对视图做统一的修改，主要体现在Model上
	@Override 
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle()...");
		
	}

	//执行时机：在执行controller之前来执行
	@Override 
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("preHandle()...");
		return true;
	}
	
}

package com.yjy.web.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//�༭������
public class MyIntercepor implements HandlerInterceptor {
	//ִ��ʱ������ͼ�Ѿ����������,����try catch ���finally
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse response, Object object, Exception e)
			throws Exception {
		System.out.println("afterCompletion()...");
		if(e != null){
			System.out.println(e);  //����쳣
		}
		System.out.println("================");
	}
	
	//ִ��ʱ����controllerִ���꣬��ͼ������û�а���ͼ������ҳ��, ����ͼ��ͳһ���޸ģ���Ҫ������Model��
	@Override 
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle()...");
		
	}

	//ִ��ʱ������ִ��controller֮ǰ��ִ��
	@Override 
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("preHandle()...");
		return true;
	}
	
}

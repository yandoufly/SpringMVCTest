package com.yjy.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginHanlerInterceptor extends HandlerInterceptorAdapter {
    
    private String loginUrl;
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        //1�����󵽵�¼ҳ�� ����
        if(request.getServletPath().startsWith(loginUrl)) {
            return true;
        }
        
        //2��TODO �����˳�����ҳ��ҳ�������¼�����˴�Ҫ���� �����ο͵�����
        
        //3������û��Ѿ���¼ ����  
        if(request.getSession().getAttribute("username") != null) {
            //���õ�ʵ�ַ�ʽ��ʹ��cookie
            return true;
        }
        
        //4���Ƿ����� ����Щ������Ҫ��¼����ܷ���
        //�ض��򵽵�¼ҳ��
        response.sendRedirect(request.getContextPath() + loginUrl);
        return false;
    }

}

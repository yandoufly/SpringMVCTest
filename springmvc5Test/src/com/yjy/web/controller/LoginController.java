package com.yjy.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if("GET".equalsIgnoreCase(req.getMethod())) {//1��������get������ʾ����¼ҳ��
            return new ModelAndView("login");
        }
        
        //2����get�����ʾ�ύ��¼
        String username = ServletRequestUtils.getStringParameter(req, "username");
        if("yan".equals(username)) {//2.1���û���Ϊzhangʱ��ʾ��¼�ɹ�
            //TODO ��¼�ɹ�����û���ŵ�cookie/session ���������ñ�־
            //2.2����session����username��ʾ��¼�ɹ�
            req.getSession().setAttribute("username", username);
            return new ModelAndView("loginSuccess");
        }
  
        //3����¼ʧ�ܣ��ٷ��ص���¼���� ��¼����Ӧ����ʾ������Ϣ
        return new ModelAndView("login");
    }

}

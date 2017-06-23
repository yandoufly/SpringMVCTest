package com.yjy.web.controller.consumesproduces.contenttype;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestContentTypeController {

    
    @RequestMapping(value = "/request/ContentType", method = RequestMethod.GET)
    public String showForm() throws IOException {
        //form����ʹ��application/x-www-form-urlencoded���뷽ʽ�ύ��
        return "consumesproduces/Content-Type";
    }
    
    //request1���ܴ�������ֻ������ͷΪ��Content-Type:application/x-www-form-urlencoded����������д����������������������ݣ�
    @RequestMapping(value = "/request/ContentType", method = RequestMethod.POST, 
                    headers = "Content-Type=application/x-www-form-urlencoded")
    public String request1(HttpServletRequest request) throws IOException {
        //�ٵõ���������������ݵ�����
        String contentType = request.getContentType(); 
        System.out.println("========ContentType:" + contentType);
        //�ڵõ���������������ݵı��뷽ʽ�����������û��ָ����Ϊnull
        //ע�⣬���ǵ�CharacterEncodingFilter��������������˱���(UTF-8)
        //����ֻ�ܱ�ָ��һ�Σ�������ͻ��������˱��룬�����������������
        String characterEncoding = request.getCharacterEncoding();
        System.out.println("========CharacterEncoding:" + characterEncoding);
        
        //�۱�ʾ���������������Ϊform���ύ�Ĳ�������ʱ���ǿ���ͨ��request.getParameter�õ����ݣ�key=value��
        System.out.println(request.getParameter("realname"));
        System.out.println(request.getParameter("username"));
        return "success";
        
    }
    
    //request2���ܴ�������ֻ������ͷΪ��Content-Type:application/json���Ľ����������������������������ݣ�
    @RequestMapping(value = "/request/ContentType", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public String request2(HttpServletRequest request) throws IOException {        
        //��ʾ���������������Ϊjson����
        InputStream is = request.getInputStream();
        byte bytes[] = new byte[request.getContentLength()];
        is.read(bytes);
        //�õ������е����������ݣ���CharacterEncoding���룩
        //�˴��õ����ݺ������ͨ����json-libת��Ϊ��������
        String jsonStr = new String(bytes, request.getCharacterEncoding());
        System.out.println("json data��" + jsonStr);
        return "success";
    }
    
    
    
    
}

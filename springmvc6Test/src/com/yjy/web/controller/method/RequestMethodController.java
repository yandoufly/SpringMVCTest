package com.yjy.web.controller.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customers/**")                                  //�ٴ�������ͨ��ӳ��ǰ׺
public class RequestMethodController {
    @RequestMapping(value="/create", method = RequestMethod.GET)  //�ڽ����༶���@RequestMappingխ��
    public String showForm() {
        System.out.println("===============GET");
        return "customer/create";        
    }
    @RequestMapping(value="/create", method = RequestMethod.POST) //�۽����༶���@RequestMappingխ��
    public String submit() {
        System.out.println("================POST");
        return "success";        
    }
    
    @RequestMapping(value="/methodOr", method = {RequestMethod.POST, RequestMethod.GET})
    public String or() {
        System.out.println("================GET or POST");
        return "success";        
    }
}

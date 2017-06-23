package com.yjy.web.controller.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/parameter2")                      //�ٴ�������ͨ��ӳ��ǰ׺
public class RequestParameterController2 {

    @RequestMapping(params="submitFlag=create", method=RequestMethod.GET)  //�ڽ����༶���@RequestMappingխ��
    public String showForm() {
        System.out.println("===============showForm");
        return "parameter/create";        
    }
    @RequestMapping(params="submitFlag=create", method=RequestMethod.POST)   //�۽����༶���@RequestMappingխ��
    public String submit() {
        System.out.println("===============submit");
        return "success";        
    }
    
    
    //�������submitFlag ������ create
    @RequestMapping(params="submitFlag!=create", method=RequestMethod.GET)  //�����༶���@RequestMappingխ��
    public String error() {
        System.out.println("================error");
        return "success";        
    }
    
    
    
    
}

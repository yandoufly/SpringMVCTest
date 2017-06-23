package com.yjy.web.controller.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/parameter3")                      //�ٴ�������ͨ��ӳ��ǰ׺
public class RequestParameterController3 {

    @RequestMapping(params={"test1", "test2=create"})  //�ڽ����༶���@RequestMappingխ��
    public String test() {
        System.out.println("===============test1 and test2=create");
        return "parameter/create";        
    }
}

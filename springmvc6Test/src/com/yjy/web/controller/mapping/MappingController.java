package com.yjy.web.controller.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * URL����ӳ�� 
 *
 */
@Controller
public class MappingController {
    
    //��ͨURL·��ӳ��
    @RequestMapping(value={"/test1", "/user/create"})
    public String test11() {
        System.out.println("/test1  or /user/create  matches");
        return "mappingSuccess";
    }
    //��ͨURL·��ӳ��    
    @RequestMapping(value="/users/{userId}/topics/{topicId}")
    public String test12() {
        System.out.println("/users/{userId}/topics/{topicId} matches");
        return "mappingSuccess";
    }
    
    //URIģ��ģʽӳ��
    @RequestMapping(value="/users/{userId}")
    public String test21() {
        System.out.println("/users/{userId}  matches");
        return "mappingSuccess";
    }
    
    //URIģ��ģʽӳ��
    @RequestMapping(value="/users/{userId}/create")
    public String test22() {
        System.out.println("/users/{userId}/create  matches");
        return "mappingSuccess";
    }
    
    //Ant����URL·��ӳ��
    @RequestMapping(value="/users/**")
    public String test31() {
        System.out.println("/users/**  matches");
        return "mappingSuccess";
    }
    
    //Ant����URL·��ӳ��
    @RequestMapping(value="/product?")
    public String test32() {
        System.out.println("/product?  matches");
        return "mappingSuccess";
    }
    
    //Ant����URL·��ӳ��
    @RequestMapping(value="/product*")
    public String test33() {
        System.out.println("/product*  matches");
        return "mappingSuccess";
    }
    //Ant����URL·��ӳ��
    @RequestMapping(value="/product/*")
    public String test34() {
        System.out.println("/product/*  matches");
        return "mappingSuccess";
    }
    
    @RequestMapping(value="/products/**/{productId}")
    public String test35() {
        System.out.println("/products/**/{productId}  matches");
        return "mappingSuccess";
    }
    
    @RequestMapping(value="/products/{categoryCode:\\d+}-{pageNumber:\\d+}")
    public String test41() {
        System.out.println("/products/{categoryCode:\\d+}-{pageNumber:\\d+}  matches");
        return "mappingSuccess";
    }
}

package org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.service.MainService;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @ResponseBody
    @RequestMapping()
    public String test(){
//        实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        mainService.save();
        return "test";
    }
}

package org.yaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaoyan.service.MainService;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @ResponseBody
    @RequestMapping(value="test", method = RequestMethod.GET)
    public String test(){
//        实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        mainService.save();
        return "test";
    }
}

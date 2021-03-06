package com.example.springbootstep04.controller;

import com.example.springbootstep04.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * 类说明:
 *
 * @Author: 黄刚
 * @Date: 2020/5/1 1:28
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if("aaa".equals(user)){
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello","<h1>你好!</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        //classpath/templates/success.html
        return "success";
    }


   /* @RequestMapping({"/","/index.html"})
    public String index() {
        return "index";
    }*/
}

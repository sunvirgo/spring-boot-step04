package com.example.springbootstep04.controller;

import com.example.springbootstep04.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/5/18 20:44
 */
@ControllerAdvice
public class MyExceptionHandler {

    //1.浏览器和客户端返回的都是Json
    /*@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/

    //2.自适应
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap();
        //传入自己的错误状态码：4xx 5xx
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("ext", map);
        //转发到/error
        return "forward:/error";
    }
}

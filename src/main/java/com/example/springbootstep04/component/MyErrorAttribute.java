package com.example.springbootstep04.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Map;

/**
 * 类说明:
 *
 * @Author: 黄刚
 * @Date: 2020/5/18 21:30
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    //给容器中加入我们自己定义的Attribute
    //返回的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("author","sunvirgo");
        //我们的异常处理器携带的数据
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        return map;
    }

}

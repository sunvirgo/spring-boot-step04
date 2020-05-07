package com.example.springbootstep04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 类说明:
 *使用WebMvcConfigurerAdapter可以扩展SpringMvc功能
 * @Author: 黄刚
 * @Date: 2020/5/5 22:03
 */
//全面接管springMvc
//@EnableWebMvc
//扩展 springMvc
@Configuration
public class MyMvconfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/sunvirgo请求来到success页面
        registry.addViewController("/sunvirgo").setViewName("success");
        //super.addViewControllers(registry);
    }

    //所有的WebMvcConfigurerAdapter组件会一起起作用
    @Bean//将组件祖册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };

        return webMvcConfigurerAdapter;
    }
}

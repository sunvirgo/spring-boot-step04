package com.example.springbootstep04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBootStep04Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStep04Application.class, args);
    }

    @Bean
    public ViewResolver myViewResolver() {
        return new myViewResolver();
    }

    public static class myViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}

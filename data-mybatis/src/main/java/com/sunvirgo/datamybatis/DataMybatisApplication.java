package com.sunvirgo.datamybatis;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//配置mapper注解扫描
@MapperScan(value = "com.sunvirgo.datamybatis.mapper")
@SpringBootApplication
public class DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataMybatisApplication.class, args);
    }

}

package com.sunvirgo.datajpa.entity;

import javax.persistence.*;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/6/20 19:49
 **/
//使用JPA注解配置映射关系
@Entity//告诉JPA这是一个实体类
@Table(name = "tbl_user")//@Table来指定和那个数据表对应，如果省略默认表名就是User
public class User {
    @Id//这个是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer id;
    @Column(name = "last_name",length = 50)//这是和数据表对应的一个列
    private String lastName;
    @Column//省略，默认列名就是属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

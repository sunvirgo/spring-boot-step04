package com.sunvirgo.datajpa.repository;

import com.sunvirgo.datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 类说明:
 *继承JpaRepository来完成对数据库的操作
 * @author : 黄刚
 * @date : 2020/6/20 20:00
 **/
public interface UserRepository extends JpaRepository<User,Integer> {
}

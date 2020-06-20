package com.sunvirgo.datajpa.controller;

import com.sunvirgo.datajpa.entity.User;
import com.sunvirgo.datajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/6/20 20:11
 **/
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    /**
     * 方法说明:
     * @author : 黄刚
     * @date : 2020/6/20 20:30
     * @para : [id]
     * @return : com.sunvirgo.datajpa.entity.User
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    /**
     * 方法说明:
     * @author : 黄刚
     * @date : 2020/6/20 20:30
     * @para : []
     * @return : com.sunvirgo.datajpa.entity.User
     */
    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return user;
    }
}

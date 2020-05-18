package com.example.springbootstep04.exception;

/**
 * 类说明:
 *
 * @Author: 黄刚
 * @Date: 2020/5/18 20:27
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException(){
        super("用户不存在！");
    }
}

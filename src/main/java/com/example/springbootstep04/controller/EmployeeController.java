package com.example.springbootstep04.controller;

import com.example.springbootstep04.dao.EmployeeDao;
import com.example.springbootstep04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * 类说明:
 *
 * @Author: 黄刚
 * @Date: 2020/5/9 23:53
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        //ehymeleaf默认会拼串
        //classpath:/templates/**.html
        return "emp/list";
    }
}

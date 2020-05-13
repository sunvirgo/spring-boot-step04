package com.example.springbootstep04.controller;

import com.example.springbootstep04.dao.DepartmentDao;
import com.example.springbootstep04.dao.EmployeeDao;
import com.example.springbootstep04.entities.Department;
import com.example.springbootstep04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @Autowired
    private DepartmentDao departmentDao;
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

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有的部门，在页面显示
        Collection<Department> departments= departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    //springMvc自动将请求参数和入参对象的属性进行---绑定,要求请求参数的名字和javabean入参的对象的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //来到员工列表页面
        System.out.println("保存的员工信息："+employee.toString());
        //保存员工
        employeeDao.save(employee);
        //redirect:表示重定向到一个地址 /代表当前项目路径
        //forward:表示转发到一个地址
        return "redirect:/emps";
    }
}

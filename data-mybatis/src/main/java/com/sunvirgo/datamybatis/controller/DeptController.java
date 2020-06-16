package com.sunvirgo.datamybatis.controller;

import com.sunvirgo.datamybatis.bean.Department;
import com.sunvirgo.datamybatis.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/6/16 20:45
 **/
@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 方法说明:
     * @author : 黄刚
     * @date : 2020/6/16 20:47
     * @para : [id]
     * @return : com.sunvirgo.datamybatis.mapper.DepartmentMapper
     */
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }

    /**
     * 方法说明: 
     * @author : 黄刚
     * @date : 2020/6/16 21:02
     * @para : [id]
     * @return : com.sunvirgo.datamybatis.bean.Department
     */ 
    @GetMapping("/dept")
    public Department insertDept(Department dept) {
        departmentMapper.insertDept(dept);
        return dept;
    }
}

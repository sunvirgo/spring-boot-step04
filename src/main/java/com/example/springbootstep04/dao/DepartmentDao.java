package com.example.springbootstep04.dao;

import com.example.springbootstep04.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 类说明:
 *
 * @Author: 黄刚
 * @Date: 2020/5/10 0:18
 */
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    static{
        departments = new HashMap<Integer, Department>();
        departments.put(1,new Department(1,"A部门"));
        departments.put(2,new Department(2,"B部门"));
        departments.put(3,new Department(3,"C部门"));
        departments.put(4,new Department(4,"D部门"));
        departments.put(5,new Department(5,"E部门"));
    }
    public Department getDepartment(Integer id){
        return departments.get(id);
    }
    public Collection<Department> getDepartments(){
        return departments.values();
    }
}

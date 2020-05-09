package com.example.springbootstep04.dao;

import com.example.springbootstep04.entities.Department;
import com.example.springbootstep04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 类说明:
 *
 * @Author: 黄刚
 * @Date: 2020/5/10 0:15
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001,"E-AA","aa@163.com",1,new Department()));
        employees.put(1002, new Employee(1002,"E-BB","bb@163.com",1,new Department()));
        employees.put(1003, new Employee(1003,"E-CC","cc@163.com",0,new Department()));
        employees.put(1004, new Employee(1004,"E-DD","dd@163.com",0,new Department()));
        employees.put(1005, new Employee(1005,"E-EE","ee@163.com",1,new Department()));
    }
    private static Integer initId=1006;
    /**
     * 方法说明:
     * @Author: 黄刚
     * @Date: 2020/5/10 0:35
     * @Param: [employee]
     * @Return: void
     */
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        //employee.setDepartment();
        employees.put(employee.getId(), employee);
    }
    /**
     * 方法说明:查询所有员工
     * @Author: 黄刚
     * @Date: 2020/5/10 0:35
     * @Param: []
     * @Return: java.util.Collection<com.example.springbootstep04.entities.Employee>
     */
    public Collection<Employee> getAll(){
        return employees.values();
    }
    /**
     * 方法说明:
     * @Author: 黄刚
     * @Date: 2020/5/10 0:36
     * @Param: []
     * @Return: com.example.springbootstep04.entities.Employee
     */
    public Employee get(Integer id){
        return employees.get(id);
    }
    /**
     * 方法说明:
     * @Author: 黄刚
     * @Date: 2020/5/10 0:38
     * @Param: [id]
     * @Return: void
     * @return
     */
    public Employee delete(Integer id){
        return employees.remove(id);
    }
}

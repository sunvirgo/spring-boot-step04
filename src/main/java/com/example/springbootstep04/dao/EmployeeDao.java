package com.example.springbootstep04.dao;

import com.example.springbootstep04.entities.Department;
import com.example.springbootstep04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/5/10 0:15
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001,"zhangsan","aa@163.com",1,new Department(1,"A部门"),new Date()));
        employees.put(1002, new Employee(1002,"lisi","bb@163.com",0,new Department(2,"B部门"),new Date()));
        employees.put(1003, new Employee(1003,"zhaoliu","cc@163.com",0,new Department(3,"C部门"),new Date()));
        employees.put(1004, new Employee(1004,"lijiaqi","dd@163.com",0,new Department(4,"D部门"),new Date()));
        employees.put(1005, new Employee(1005,"zhaosichun","ee@163.com",1,new Department(5,"E部门"),new Date()));
    }
    private static Integer initId=1006;
    /**
     * 方法说明:
     * @author : 黄刚
     * @date : 2020/5/30 20:21
     * @para : [employee]
     * @return : void
     */
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    /**
     * 方法说明:查询所有员工
     * @author : 黄刚
     * @date : 2020/5/10 0:35
     * @para : []
     * @return : java.util.Collection<com.example.springbootstep04.entities.Employee>
     */
    public Collection<Employee> getAll(){
        return employees.values();
    }
    /**
     * 方法说明:
     * @author : 黄刚
     * @date : 2020/5/30 20:21
     * @para : [id]
     * @return : com.example.springbootstep04.entities.Employee
     */
    public Employee get(Integer id){
        return employees.get(id);
    }
    /**
     * 方法说明:
     * @author : 黄刚
     * @date : 2020/5/30 20:21
     * @para : [id]
     * @return : com.example.springbootstep04.entities.Employee
     */
    public Employee delete(Integer id){
        return employees.remove(id);
    }
}

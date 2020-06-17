package com.sunvirgo.datamybatis.mapper;

import com.sunvirgo.datamybatis.bean.Employee;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/6/17 21:33
 **/
//@Mapper或者@MapperScan将接口扫描装配到容器中
@Component
public interface EmployeeMapper {
    /**
     * 方法说明: 
     * @author : 黄刚
     * @date : 2020/6/17 21:34
     * @para : []
     * @return : com.sunvirgo.datamybatis.bean.Employee
     */ 
    public Employee getEmpById(Integer id);
    
    /**
     * 方法说明: 
     * @author : 黄刚
     * @date : 2020/6/17 21:36
     * @para : [employee]
     * @return : void
     */ 
    public void insertEmp(Employee employee);
}

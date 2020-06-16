package com.sunvirgo.datamybatis.mapper;

import com.sunvirgo.datamybatis.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/6/16 20:32
 **/
//指定这是一个操作数据库的Mapper
//@Mapper 可以在main方法配置扫描指定包下mapper，而不用每个都配置注解
@Component
public interface DepartmentMapper {
    /**
     * 方法说明:
     * @author : 黄刚
     * @date : 2020/6/16 20:37
     * @para : [id]
     * @return : com.sunvirgo.datamybatis.bean.Department
     */
    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    /**
     * 方法说明:
     * @author : 黄刚
     * @date : 2020/6/16 20:40
     * @para : [id]
     * @return : int
     */
    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);

    /**
     * 方法说明:
     * @author : 黄刚
     * @date : 2020/6/16 20:42
     * @para : [dept]
     * @return : int
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department dept);

    /**
     * 方法说明:
     * @author : 黄刚
     * @date : 2020/6/16 20:43
     * @para : [dept]
     * @return : int
     */
    @Update("update department set departmentName=#{departmentName} where id =#{id}")
    public int updateDept(Department dept);
}

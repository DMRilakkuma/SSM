package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {


    /*
     * 根据条件查询员工信息
     * */
    List<Emp> getEmpByCondition(Emp emp);

    /*
     * 使用choose查询员工信息
     * */
    List<Emp> getEmpByChoose(Emp emp);


    /*
     * 批量·添加员工信息*/
    void insertMoreEmp(@Param("emps") List<Emp> emps);


    void deleteMoreEmp(@Param("empIds") Integer[] empId);

}

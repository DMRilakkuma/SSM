package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    Emp getEmpByEmpId(@Param("empId") Integer empId);


    /*获取员工所对应的部门信息*/
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /*
     * 查询员工以及所对应的部门信息的第一步
     * */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);


    /*查询员工以及所对应的部门信息的第二步*/
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);

}

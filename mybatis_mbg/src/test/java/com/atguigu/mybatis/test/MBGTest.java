package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-26 10:15
 * @Description:
 */

public class MBGTest {

    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // List<Emp> list = mapper.selectByExample(null);
        // System.out.println(list);

        // 根据条件查询数据
        // EmpExample example = new EmpExample();
        // example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
        // example.or().andGenderEqualTo("男");
        // List<Emp> list = mapper.selectByExample(example);
        // list.forEach(System.out::println);

        //测试普通修改功能
        Emp emp = new Emp(1, "小黑", null, "女", null);
        // mapper.updateByPrimaryKey(emp);

        // 测试选择性修改
        mapper.updateByPrimaryKeySelective(emp);

    }
}
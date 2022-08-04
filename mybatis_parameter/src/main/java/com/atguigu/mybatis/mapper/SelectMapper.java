package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {


    /*诺sql语句查询的结果为多条时,一定不能以实体类类型作为方法的返回值
    否则会抛出异常 TooManyResultsException
    诺sql语句查询的结果为一条时,可以使用实体类类型或者list集合类型作为返回值
    * */
    /*根据id查询用户信息*/
    User getUserById(@Param("id") Integer id);

    /*查询用户的所有的信息*/
    List<User> getAllUser();

    /*
     * 查询用户的总数量*/
    Integer getCount();


    /*
     * 根据id查询用户信息为一个map集合
     * */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /*
     * 查询所有的用户信息为map集合
     *诺查询的数据有多条时，并且要将每条数据转化为map集合
     * 此时有两种解决方法
     * 1.将mapper接口方法的返回值设置为泛型是map的map的list集合
     *   List<Map<String, Object>> list = mapper.getAllUserToMap();]
        {1={password=123456, gender=男, id=1, age=23, email=12345@qq, username=admin},
        * 2={password=123456, gender=女, id=2, age=33, email=12345@qq.com, username=root},
         3={password=123456, gender=女, id=3, age=33, email=12345@qq.com, username=root},
         * 4={password=123, id=4, username=list}}
         *
       2.可以将每条数据转化为map的集合放在一个大map中，但是必须要通过@MapKey注解
       * 将查询到的某个字段的值作为大map的键
       *  @MapKey("id")
    Map<String, Object> getAllUserToMap();
      */

//    List<Map<String, Object>> getAllUserToMap();

    @MapKey("id")
    Map<String, Object> getAllUserToMap();
}
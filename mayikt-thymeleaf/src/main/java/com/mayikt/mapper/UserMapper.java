package com.mayikt.mapper;

import com.mayikt.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("insert into users values (null,#{userName},#{age});")
    int insertUser(@Param("userName") String userName, @Param("age") Integer age);

    @Select("select id as id,name as userName,age as age  from users where id = #{id}")
    UserEntity selectByUserId(@Param("id") Integer id);
}

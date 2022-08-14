package com.mayikt.entity;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-14 23:01
 * @Description:
 */

public class UserEntity {

    private String userName;

    private Integer age;

    private  Integer id;

    public UserEntity() {
    }

    public UserEntity(String userName, Integer age, Integer id) {
        this.userName = userName;
        this.age = age;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
package com.atguigu.spring.pojo;

import java.util.Arrays;
import java.util.Map;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-27 20:28
 * @Description:
 */

public class Student implements Person{

    private Integer id;

    private String sname;

    private Integer age;

    private String gender;

    private Double score;

    private String[] hobby;

    private  Clazz clazz;

    private Map<String,Teacher> teacherMap;



    public Student() {
    }

    public Student(Integer id, String sname, String gender , Integer age) {
        this.id = id;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
    }

    public Student(Integer id, String sname, String gender , Double score) {
        this.id = id;
        this.sname = sname;
        this.score = score;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", hobby=" + Arrays.toString(hobby) +
                ", clazz=" + clazz +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
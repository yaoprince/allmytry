package com.myxuexi.testredismysql.service;

import com.myxuexi.testredismysql.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAll();

    Student getStudent(String numberCode);

    int delete(String numberCode);

    public long decr(String key, long delta);

//    int update(Student student);
//
//    int insert(Student student);
}

package com.pzh.mall.module.service;

import com.pzh.mall.module.domain.Student;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 20:22
 * @Version 1.0
 */
public interface StudentService {
    int add(Student student);
    int update(Student student);
    int deleteBySno(String sno);
    Student queryStudentBySno(String sno);
    List<Student> queryAllStudents();
}

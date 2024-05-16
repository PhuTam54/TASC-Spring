package com.phutam.springboot.demo.mycoolapp.service;

import com.phutam.springboot.demo.mycoolapp.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    Student findById(int id);
    List<Student> findAll();
//    Student findByEmail(String email);
    void delete(int id);
}

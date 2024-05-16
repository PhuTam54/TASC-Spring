package com.phutam.springboot.demo.mycoolapp.dao;

import com.phutam.springboot.demo.mycoolapp.entity.Student;

import java.util.List;

public interface StudentDAO {
    Student save(Student student);
    Student findById(int id);
    List<Student> findAll();
    Student findByEmail(String email);
    void delete(int id);
}

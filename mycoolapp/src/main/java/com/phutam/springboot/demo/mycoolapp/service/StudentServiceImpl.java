package com.phutam.springboot.demo.mycoolapp.service;

import com.phutam.springboot.demo.mycoolapp.dao.StudentRepository;
import com.phutam.springboot.demo.mycoolapp.entity.Student;
import com.phutam.springboot.demo.mycoolapp.exception.student.StudentNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository StudentRepository;
    public StudentServiceImpl(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }

    @Override
    public Student save(Student student) {
        Student dbStudent = StudentRepository.save(student);
        return dbStudent;
    }

    @Override
    public Student findById(int id) {
        Optional<Student> result = StudentRepository.findById(id);
        Student student;
        if (result.isPresent()) {
            student = result.get();
        } else {
            throw new StudentNotFoundException("Did not find student id - " + id);
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return StudentRepository.findAll();
    }

//    @Override
//    public Student findByEmail(String email) {
//        return StudentRepository.findByEmail(email);
//    }

    @Override
    public void delete(int id) {
        StudentRepository.deleteById(id);
    }
}

package com.phutam.springboot.demo.mycoolapp.dao;

import com.phutam.springboot.demo.mycoolapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOJpaImpl implements StudentDAO{
    private final EntityManager entityManager;
    @Autowired
    public StudentDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student save(Student student) {
        Student dbStudent = entityManager.merge(student);
        return dbStudent;
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student order by name", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findByEmail(String email) {
        TypedQuery<Student> query = entityManager.createQuery("from Student where email like :email", Student.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public void delete(int id) {
        Student student = findById(id);
        entityManager.remove(student);
    }
}

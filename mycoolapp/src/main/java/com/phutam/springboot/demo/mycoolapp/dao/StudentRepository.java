package com.phutam.springboot.demo.mycoolapp.dao;

import com.phutam.springboot.demo.mycoolapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface StudentRepository extends JpaRepository<Student, Integer> {
}

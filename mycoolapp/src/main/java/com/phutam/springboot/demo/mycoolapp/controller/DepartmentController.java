package com.phutam.springboot.demo.mycoolapp.controller;

import com.phutam.springboot.demo.mycoolapp.common.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {
    private final Department department;
    private final Department anotherDepartment;
    @Autowired
    public DepartmentController(
            @Qualifier("ITDepartment") Department department,
            @Qualifier("ITDepartment") Department anotherDepartment
    ) {
        System.out.println("DepartmentController bean created: " + getClass().getSimpleName());
        this.department = department;
        this.anotherDepartment = anotherDepartment;
    }

    @Autowired
    @Qualifier("saleDepartment")
    Department department1;

    @Autowired
    @Qualifier("marketingDepartment")
    Department department2;

    @GetMapping("/greet")
    public void greet() {
        department.greet();
        department1.greet();
        department2.greet();
    }

    @GetMapping("/checkIsTheSameBean")
    public String checkIsTheSameBean() {
        return department == (anotherDepartment) ? "Yes" : "No";
        // Singleton scope by default return true
        // Prototype scope return false
    }

    @GetMapping("/getAllDepartment")
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        departments.add(department);
        departments.add(department1);
        departments.add(department2);
        return departments;
    }
}

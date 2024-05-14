package com.phutam.springboot.demo.mycoolapp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class SaleDepartment implements Department{
    public SaleDepartment() {
        System.out.println("ITDepartment bean created: " + getClass().getSimpleName());
    }
    public void greet() {
        System.out.println("Hello, I am departmentSale");
    }
}

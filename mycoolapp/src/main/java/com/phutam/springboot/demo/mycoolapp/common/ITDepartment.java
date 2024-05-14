package com.phutam.springboot.demo.mycoolapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) ----------- Only Singleton can use PreDestroy
// Prototype beans are lazy by default. There is no need to use the @Lazy annotation for prototype scopes beans.
public class ITDepartment implements Department{
    public ITDepartment() {
        System.out.println("ITDepartment bean created: " + getClass().getSimpleName());
    }
    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.println("In doMyStartUpStuff: " + getClass().getSimpleName());
    }
    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println("In doMyCleanUpStuff: " + getClass().getSimpleName());
    }
    public void greet() {
        System.out.println("Hello, I am departmentIT");
    }
}

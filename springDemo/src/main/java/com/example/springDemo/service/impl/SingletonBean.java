package com.example.springDemo.service.impl;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    public SingletonBean(){
        System.out.println("SingletonBean....");
    }
}
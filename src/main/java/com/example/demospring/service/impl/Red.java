package com.example.demospring.service.impl;

import com.example.demospring.service.Color;

public class Red implements Color {
    @Override
    public void wear() {
        System.out.println("Wearing red");
    }
}

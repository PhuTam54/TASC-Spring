package com.phutam.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String name;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/coding")
    public String coding() {
        return name + " is coding now for " + teamName;
    }

    @GetMapping("/fixingBug")
    public String fixingBug() {
        return "Phu Tam is fixing the Bug!";
    }
}

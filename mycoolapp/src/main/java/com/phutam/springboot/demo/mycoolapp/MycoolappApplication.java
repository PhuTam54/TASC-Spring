package com.phutam.springboot.demo.mycoolapp;

import com.phutam.springboot.demo.mycoolapp.entity.Department;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages =
		{"com.phutam.springboot.demo.mycoolapp",
		"com.phutam.springboot.demo.utils"})
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean("department1")
	public Department instance() {
		return new Department(1, "IT");
	}

	@Bean("department2")
	public Department instance2() {
		return new Department(2, "IT 2");
	}
}

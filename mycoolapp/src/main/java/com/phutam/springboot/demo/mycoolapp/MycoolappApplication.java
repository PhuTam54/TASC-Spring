package com.phutam.springboot.demo.mycoolapp;

import com.phutam.springboot.demo.mycoolapp.dao.StudentDAO;
import com.phutam.springboot.demo.mycoolapp.entity.Department;
import com.phutam.springboot.demo.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
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

	@Bean("studentDAOCommandLineRunner")
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
//			CreateStudent(studentDAO);
//			ReadStudent(studentDAO);
//			queryStudents(studentDAO);
//			getStudentByName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// Delete student
		System.out.println("Delete student by id: 3");
		studentDAO.delete(3);
		System.out.println("Deleted student by id: 3");
		queryStudents(studentDAO);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Update student
		System.out.println("Update student by id: 1");
		Student student = studentDAO.findById(1);
		student.setName("Tam Phu");
//		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}

	private void getStudentByName(StudentDAO studentDAO) {
		// Get student by name
		System.out.println("Get student by email: phutamytb@gmail.com");
		Student student = studentDAO.findByEmail("phutamytb@gmail.com");
		System.out.println("Founded student: " + student);
	}

	private void queryStudents(StudentDAO studentDAO) {
		// Get all students
		System.out.println("Get all students...");
		studentDAO.findAll().forEach(System.out::println);
	}

	private void ReadStudent(StudentDAO studentDAO) {
		// Create a student
		System.out.println("Creating a student...");
		Student student = new Student("Tam", "thuytam@gmail.com", "1234567890");
		// Save the student
		System.out.println("Saving the student...");
		studentDAO.save(student);
		// Display the student
		System.out.println("Saved student: " + student);
		// Get the student base on the id
		System.out.println("Get student by id: " + student.getId());
		Student foundedStudent = studentDAO.findById(student.getId());
		System.out.println("Founded student: " + foundedStudent);
	}

	private void CreateStudent(StudentDAO studentDAO) {
		// Create a student
		System.out.println("Creating a student...");
		Student student = new Student("Tam", "phutamytb123@gmail.com", "1234567890");
		// Save the student
		System.out.println("Saving the student...");
		studentDAO.save(student);
		// Display the student
		System.out.println("Saved student: " + student);
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

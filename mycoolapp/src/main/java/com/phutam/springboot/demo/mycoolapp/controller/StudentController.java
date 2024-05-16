package com.phutam.springboot.demo.mycoolapp.controller;

import com.phutam.springboot.demo.mycoolapp.entity.Student;
import com.phutam.springboot.demo.mycoolapp.exception.student.StudentNotFoundException;
import com.phutam.springboot.demo.mycoolapp.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Student", description = "Student Controller")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = studentService.findById(id);
        if (student == null)
            throw new StudentNotFoundException("Student id not found: " + id);
        return student;
    }

//    @GetMapping("/students/email/{email}")
//    public Student getStudent(@PathVariable String email) {
//        Student student = studentService.findByEmail(email);
//        if (student == null)
//            throw new StudentNotFoundException("Student id not found: " + email);
//        return student;
//    }

    @Operation(
            summary = "Add new Student",
            description = "Add student")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/students")
    public Student addStudent(@Valid @RequestBody Student student) {
        student.setId(0);
        Student dbStudent = studentService.save(student);
        return dbStudent;
    }

    @PutMapping("/students")
    public Student updateStudent(@Valid @RequestBody Student student) {
        studentService.save(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        Student student = studentService.findById(id);
        if (student == null)
            throw new StudentNotFoundException("Student id not found: " + id);
        studentService.delete(id);
        return "Deleted student id: " + id;
    }
}

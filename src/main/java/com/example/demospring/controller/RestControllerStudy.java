package com.example.demospring.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.example.demospring.entity.User;

import java.util.stream.Collectors;

@Tag(name = "RestController", description = "Test RestController")
@RestController
@RequestMapping("/api/v1")
public class RestControllerStudy {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/users")
    public String createUser(@Valid @RequestBody User user) {

        return "User created: " + user.getName() + " - " + user.getAge();
    }
    // Xử lý GET request tại /api/v1/hello
    @GetMapping("/hello")
    public String hello(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent: " + userAgent;
    }

    @GetMapping("/hellowithcookie")
    public String helloWithCookie(@CookieValue("username") String username) {
        return "Hello, " + username;
    }

    // Xử lý POST request tại /api/v1/data
    @PostMapping("/data")
    public String postData(@RequestBody String data) {
        return "Data received: " + data;
    }

    // Xử lý PUT request tại /api/v1/data/{id}
    @PutMapping("/data/{id}")
    public String updateData(@PathVariable String id, @RequestBody String data) {
        return "Data updated for ID: " + id + " with data: " + data;
    }

    // Xử lý DELETE request tại /api/v1/data/{id}
    @DeleteMapping("/data/{id}")
    public String deleteData(@PathVariable String id) {
        return "Data deleted for ID: " + id;
    }
}
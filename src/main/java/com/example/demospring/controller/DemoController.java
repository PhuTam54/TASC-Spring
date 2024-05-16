package com.example.demospring.controller;

import com.example.demospring.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Demo", description = "Test Controller")
@RestController
public class DemoController {
    @GetMapping("/students")
    public String getStudent(String name){
        return name;
    }
    @Operation(
            summary = "Thêm mới Student",
            description = "Add student")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = User.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/students")
    public String createUser(@Valid @RequestBody User user) {
        int a = 1/user.getAge();
        return "User created: " + user.getName() + " - " + user.getAge();
    }
    @GetMapping("/students/{id}")
    public String getStudentById(@PathVariable("id") String id){
        return id;
    }
}

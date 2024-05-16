package com.example.demospring.entity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Schema(required = true, description = "Name of the student")
    @NotEmpty(message = "Name is mandatory")
    @Size(min = 2, max = 30)
    private String name;

    @NotNull(message = "Age is mandatory")
    private Integer age;
}
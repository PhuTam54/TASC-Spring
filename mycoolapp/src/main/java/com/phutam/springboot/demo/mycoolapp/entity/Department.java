package com.phutam.springboot.demo.mycoolapp.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @NotBlank
    private Integer id;
    @NotNull
    private String name;
}

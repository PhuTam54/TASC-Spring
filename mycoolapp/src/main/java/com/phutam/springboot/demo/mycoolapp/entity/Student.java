package com.phutam.springboot.demo.mycoolapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Name is mandatory")
    @Size(min = 2, max = 30)
    private String name;

    @Column(name = "email")
    @NotEmpty(message = "Email is mandatory")
    @Email
    private String email;

    @Column(name = "phonenumber")
    @NotEmpty(message = "Phone number is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String phoneNumber;

    public Student(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

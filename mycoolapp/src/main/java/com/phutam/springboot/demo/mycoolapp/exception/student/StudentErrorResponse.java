package com.phutam.springboot.demo.mycoolapp.exception.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}

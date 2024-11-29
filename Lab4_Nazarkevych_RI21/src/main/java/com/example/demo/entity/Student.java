package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private int age;
}

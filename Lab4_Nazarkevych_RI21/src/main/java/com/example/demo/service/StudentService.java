package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentByEmail(String email);

    Student updateStudent(Student student);

    void deleteStudent(String email);
}

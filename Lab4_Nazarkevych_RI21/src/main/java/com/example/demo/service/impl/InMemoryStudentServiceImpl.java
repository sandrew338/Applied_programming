package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.InMemoryStudentDAO;
import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryStudentServiceImpl implements StudentService {
    private final InMemoryStudentDAO repository;

    @Override
    public List<Student> getAllStudents() {
//        return List.of(
//                Student.builder().firstName("Andrii").email("Andrew@gmail.com").age(18).build(),
//                Student.builder().firstName("Andrii").email("Andrew@gmail.com").age(18).build(),
//                Student.builder().firstName("Andrii").email("Andrew@gmail.com").age(18).build()
//
//        );
        return repository.getAllStudents();
    }


    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return repository.getStudentByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        repository.deleteStudent(email);
    }
}

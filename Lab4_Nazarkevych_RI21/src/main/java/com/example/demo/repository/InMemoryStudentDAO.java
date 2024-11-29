package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDAO {
    private List<Student> STUDENTS = new ArrayList<Student>();

    public List<Student> getAllStudents() {
        return STUDENTS;
    }


    public Student saveStudent(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public Student getStudentByEmail(String email) {
        return STUDENTS.stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);
        if (studentIndex > -1) {
            return STUDENTS.set(studentIndex, student);
        } else {
            return null;
        }
    }

    public void deleteStudent(String email) {
        var student = getStudentByEmail(email);
        if (student != null) {
            STUDENTS.remove(student);
        }
    }
}

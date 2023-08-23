package com.xsakon.demo.student;

import com.xsakon.demo.student.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAllUsingQuery();
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmailUsingQuery(email);
    }
}

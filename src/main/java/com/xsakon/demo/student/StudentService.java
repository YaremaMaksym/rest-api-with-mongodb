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

    public void registerStudent(StudentRegistrationRequest request) {
        studentRepository.findStudentByEmail(request.email()).ifPresent((s) -> {
            throw new IllegalStateException("student with email " + s.getEmail() + " already exists");
        });

        Student student = new Student(
                request.firstName(),
                request.lastName(),
                request.gender(),
                request.email(),
                request.address(),
                request.registrationDate(),
                request.favoriteSubjects(),
                request.totalSpentInBooks());

        studentRepository.save(student);
    }
}

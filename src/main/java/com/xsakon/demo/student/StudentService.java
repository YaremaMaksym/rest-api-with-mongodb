package com.xsakon.demo.student;

import com.xsakon.demo.student.models.Student;
import com.xsakon.demo.student.models.StudentRegistrationRequest;
import com.xsakon.demo.student.models.StudentUpdateRequest;
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

    public void updateStudent(StudentUpdateRequest request, String email) {
        Student student = studentRepository.findStudentByEmail(email).orElseThrow(
                () -> new IllegalStateException("No student with " + email + " found to update")
        );
        boolean updated = false;

        if (request.firstName() != null && !request.firstName().equals(student.getFirstName())) {
            student.setFirstName(request.firstName());
            updated = true;
        }

        if (request.lastName() != null && !request.lastName().equals(student.getLastName())) {
            student.setLastName(request.lastName());
            updated = true;
        }

        if (request.gender() != null && !request.gender().equals(student.getGender())) {
            student.setGender(request.gender());
            updated = true;
        }

        if (request.address() != null && !request.address().equals(student.getAddress())) {
            student.setAddress(request.address());
            updated = true;
        }

        if (request.registrationDate() != null && !request.registrationDate().equals(student.getRegistrationDate())) {
            student.setRegistrationDate(request.registrationDate());
            updated = true;
        }

        if (request.favoriteSubjects() != null && !request.favoriteSubjects().equals(student.getFavoriteSubjects())) {
            student.setFavoriteSubjects(request.favoriteSubjects());
            updated = true;
        }

        if (request.totalSpentInBooks() != null && !request.totalSpentInBooks().equals(student.getTotalSpentInBooks())) {
            student.setTotalSpentInBooks(request.totalSpentInBooks());
            updated = true;
        }

        if (updated){
            System.out.println("Successfully updated");
            studentRepository.save(student);
        } else {
            System.out.println("No updated fields found");
        }
    }

    public void deleteStudent(String email) {
        Student student = studentRepository.findStudentByEmail(email).orElseThrow(
                () -> new IllegalStateException("No student with " + email + " found to update")
        );

        studentRepository.delete(student);
    }
}

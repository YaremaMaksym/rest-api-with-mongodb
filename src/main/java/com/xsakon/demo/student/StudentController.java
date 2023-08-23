package com.xsakon.demo.student;

import com.xsakon.demo.student.models.Student;
import com.xsakon.demo.student.models.StudentRegistrationRequest;
import com.xsakon.demo.student.models.StudentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("{email}")
    public Student getStudentByEmail(@PathVariable("email") String email) {
        return studentService.getStudentByEmail(email);
    }

    @PostMapping
    public void registerStudent(@RequestBody StudentRegistrationRequest request){
        studentService.registerStudent(request);
    }

    @PutMapping("{email}")
    public void updateStudent(@RequestBody StudentUpdateRequest request,
                              @PathVariable("email") String email) {
        studentService.updateStudent(request, email);
    }
}

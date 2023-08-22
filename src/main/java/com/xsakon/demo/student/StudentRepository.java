package com.xsakon.demo.student;

import com.xsakon.demo.student.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}

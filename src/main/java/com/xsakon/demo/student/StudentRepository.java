package com.xsakon.demo.student;

import com.xsakon.demo.student.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);

    @Query("db.student.find()")
    List<Student> findAllUsingQuery();

    @Query("db.student.find({'email': ?0})")
    Student findByEmailUsingQuery(String email);
}

package com.xsakon.demo.student.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    @Indexed(unique = true)
    private String email;
    private Address address;
    private LocalDateTime registrationDate;
    private List<String> favoriteSubjects;
    private BigDecimal totalSpentInBooks;

    public Student(String firstName, String lastName, Gender gender, String email, Address address, LocalDateTime registrationDate, List<String> favoriteSubjects, BigDecimal totalSpentInBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.registrationDate = registrationDate;
        this.favoriteSubjects = favoriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
    }
}

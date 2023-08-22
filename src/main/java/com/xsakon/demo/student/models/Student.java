package com.xsakon.demo.student.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private Address address;
    private ZonedDateTime registrationDate;
    private List<String> favoriteSubjects;
    private BigDecimal totalSpentInBooks;
}

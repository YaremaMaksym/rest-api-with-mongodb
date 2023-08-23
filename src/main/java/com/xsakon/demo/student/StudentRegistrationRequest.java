package com.xsakon.demo.student;

import com.xsakon.demo.student.models.Address;
import com.xsakon.demo.student.models.Gender;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record StudentRegistrationRequest(String id,
                                         String firstName,
                                         String lastName,
                                         Gender gender,
                                         String email,
                                         Address address,
                                         LocalDateTime registrationDate,
                                         List<String> favoriteSubjects,
                                         BigDecimal totalSpentInBooks) {
}

package com.xsakon.demo.student.models;

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

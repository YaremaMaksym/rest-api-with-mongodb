package com.xsakon.demo.student.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record StudentUpdateRequest(
        String firstName,
        String lastName,
        Gender gender,
        Address address,
        LocalDateTime registrationDate,
        List<String> favoriteSubjects,
        BigDecimal totalSpentInBooks) {
}

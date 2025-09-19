package com.example.Vet.Clinic.System.dto;

import java.time.LocalTime;
import java.util.Set;

public record ClinicResponse(
        Long id,
        String name,
        String address,
        String phone,
        String email,
        String facebookUrl,
        String instagramUrl,
        String websiteUrl,
        Set<String> workingDays,
        LocalTime openHour,
        LocalTime closeHour
) {
}

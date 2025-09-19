package com.example.Vet.Clinic.System.dto;

import com.example.Vet.Clinic.System.model.DayOfWeek;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.Set;

public record ClinicRequest(
        @NotBlank
        String name,
        @NotBlank
        String address,
        @NotBlank
        String phone,
        @NotNull
        Set<DayOfWeek> workingDays,
        @NotNull
        LocalTime openHour,
        @NotNull
        LocalTime closeHour,
        @Email
        String email,

        String facebookUrl,
        String instagramUrl,
        String websiteUrl
) {
}

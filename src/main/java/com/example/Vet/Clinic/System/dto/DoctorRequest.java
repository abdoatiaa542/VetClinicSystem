package com.example.Vet.Clinic.System.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DoctorRequest(
        @NotBlank String name,
        @Email String email,
        @NotBlank String phone,
        @NotNull Long clinicId
) {}

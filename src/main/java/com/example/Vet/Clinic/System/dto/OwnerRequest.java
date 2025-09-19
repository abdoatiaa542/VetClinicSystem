package com.example.Vet.Clinic.System.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record OwnerRequest(
        @NotBlank String name,
        @Email String email,
        @NotBlank String phone,
        @NotBlank String gender,
        @NotBlank String address
) {}

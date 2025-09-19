package com.example.Vet.Clinic.System.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PetRequest(
        @NotBlank
        String name,
        @NotBlank
        String gender,
        @NotNull
        LocalDate dateOfBirth,
        @NotBlank
        String animalKind,
        Double weight,
        Long ownerId
) {
}


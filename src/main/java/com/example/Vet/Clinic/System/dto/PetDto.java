package com.example.Vet.Clinic.System.dto;

import java.time.LocalDate;

public record PetDto(
        Long id,
        String name,
        String gender,
        LocalDate dateOfBirth,
        String animalKind,
        String photoUrl,
        Double weight
) {}

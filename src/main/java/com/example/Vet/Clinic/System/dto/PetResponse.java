package com.example.Vet.Clinic.System.dto;

import java.time.LocalDate;

public record PetResponse(
        Long id,
        String name,
        String gender,
        LocalDate dateOfBirth,
        String animalKind,
        Double weight,
        Long ownerId
) {}

package com.example.Vet.Clinic.System.dto;


import java.time.LocalDate;

public record VisitResponse(
        Long id,
        Long petId,
        Long doctorId,
        Long clinicId,
        LocalDate date
) {}

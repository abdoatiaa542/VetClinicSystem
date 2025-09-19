package com.example.Vet.Clinic.System.dto;

import java.time.LocalDateTime;

public record VisitDto(
        Long id,
        LocalDateTime date,
        Long petId,
        Long doctorId,
        Long clinicId
) {}

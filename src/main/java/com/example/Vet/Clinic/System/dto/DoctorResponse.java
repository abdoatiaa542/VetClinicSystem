package com.example.Vet.Clinic.System.dto;

public record DoctorResponse(
        Long id,
        String name,
        String phone,
        String email,
        String photo,
        String bio,
        Long clinicId
) {}

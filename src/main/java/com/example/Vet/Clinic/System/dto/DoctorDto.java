package com.example.Vet.Clinic.System.dto;

public record DoctorDto(
        Long id,
        String name,
        String phone,
        String photoUrl,
        String bio
) {}

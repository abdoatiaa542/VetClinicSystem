package com.example.Vet.Clinic.System.dto;

public record OwnerDto(
        Long id,
        String name,
        String email,
        String phone,
        String gender,
        String address
) {}

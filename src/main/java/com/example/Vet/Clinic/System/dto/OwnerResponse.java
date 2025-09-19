package com.example.Vet.Clinic.System.dto;

import java.util.List;

public record OwnerResponse(
        Long id,
        String name,
        String email,
        String phone,
        String gender,
        String address,
        List<PetResponse> pets
) {}

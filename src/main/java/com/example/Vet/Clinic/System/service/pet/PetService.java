package com.example.Vet.Clinic.System.service;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import com.example.Vet.Clinic.System.dto.PetRequest;

public interface PetService {
    ApiResponse addPet(PetRequest request);
    ApiResponse getPetById(Long id);
}
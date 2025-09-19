package com.example.Vet.Clinic.System.service.owner;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import com.example.Vet.Clinic.System.dto.OwnerRequest;

public interface OwnerService {
    ApiResponse addOwner(OwnerRequest request);
    ApiResponse getOwnerById(Long id);
    ApiResponse getOwnerPets(Long ownerId);
}

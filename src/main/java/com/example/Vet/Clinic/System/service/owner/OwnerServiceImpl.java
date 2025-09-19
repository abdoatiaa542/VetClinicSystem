package com.example.Vet.Clinic.System.service.owner;


import com.example.Vet.Clinic.System.dto.ApiResponse;
import com.example.Vet.Clinic.System.dto.OwnerRequest;
import com.example.Vet.Clinic.System.dto.PetResponse;
import com.example.Vet.Clinic.System.exception.ResourceNotFoundException;
import com.example.Vet.Clinic.System.mapper.OwnerMapper;
import com.example.Vet.Clinic.System.mapper.PetMapper;
import com.example.Vet.Clinic.System.model.users.Owner;
import com.example.Vet.Clinic.System.repository.OwnerRepository;
import com.example.Vet.Clinic.System.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    @Override
    public ApiResponse addOwner(OwnerRequest request) {
        Owner owner = OwnerMapper.toEntity(request);
        Owner saved = ownerRepository.save(owner);
        return ApiResponse.of("Owner created successfully", OwnerMapper.toResponse(saved));
    }

    @Override
    public ApiResponse getOwnerById(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found"));
        return ApiResponse.of("Owner fetched successfully", OwnerMapper.toResponse(owner));
    }

    @Override
    public ApiResponse getOwnerPets(Long ownerId) {
        List<PetResponse> pets = petRepository.findByOwnerId(ownerId)
                .stream().map(PetMapper::toResponse).collect(Collectors.toList());
        return ApiResponse.of("Pets fetched successfully", pets);
    }
}

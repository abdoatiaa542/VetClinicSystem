package com.example.Vet.Clinic.System.service.pet;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import com.example.Vet.Clinic.System.dto.PetRequest;
import com.example.Vet.Clinic.System.exception.ResourceNotFoundException;
import com.example.Vet.Clinic.System.mapper.PetMapper;
import com.example.Vet.Clinic.System.model.Pet;
import com.example.Vet.Clinic.System.model.users.Owner;
import com.example.Vet.Clinic.System.repository.OwnerRepository;
import com.example.Vet.Clinic.System.repository.PetRepository;
import com.example.Vet.Clinic.System.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    @Override
    public ApiResponse addPet(PetRequest request) {
        Owner owner = ownerRepository.findById(request.ownerId())
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found"));

        Pet pet = PetMapper.toEntity(request, owner);
        Pet saved = petRepository.save(pet);
        return ApiResponse.of("Pet created successfully", PetMapper.toResponse(saved));
    }

    @Override
    public ApiResponse getPetById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
        return ApiResponse.of("Pet fetched successfully", PetMapper.toResponse(pet));
    }
}

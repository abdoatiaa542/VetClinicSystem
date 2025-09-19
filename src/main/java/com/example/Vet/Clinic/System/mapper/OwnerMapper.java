package com.example.Vet.Clinic.System.mapper;

import com.example.Vet.Clinic.System.dto.OwnerRequest;
import com.example.Vet.Clinic.System.dto.OwnerResponse;
import com.example.Vet.Clinic.System.model.users.Owner;

import java.util.List;
import java.util.stream.Collectors;

public class OwnerMapper {

    public static Owner toEntity(OwnerRequest request) {
        Owner owner = new Owner();
        owner.setUsername(request.name());
        owner.setEmail(request.email());
        owner.setPhone(request.phone());
        owner.setGender(request.gender());
        owner.setAddress(request.address());
        return owner;
    }

    public static OwnerResponse toResponse(Owner owner) {
        return new OwnerResponse(
                owner.getId(),
                owner.getUsername(),
                owner.getEmail(),
                owner.getPhone(),
                owner.getGender(),
                owner.getAddress(),
                owner.getPets() != null
                        ? owner.getPets().stream().map(PetMapper::toResponse).collect(Collectors.toList())
                        : List.of()
        );
    }
}

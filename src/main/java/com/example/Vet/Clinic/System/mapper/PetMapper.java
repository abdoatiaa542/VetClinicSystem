package com.example.Vet.Clinic.System.mapper;

import com.example.Vet.Clinic.System.dto.PetRequest;
import com.example.Vet.Clinic.System.dto.PetResponse;
import com.example.Vet.Clinic.System.model.Pet;
import com.example.Vet.Clinic.System.model.users.Owner;


public class PetMapper {

    public static Pet toEntity(PetRequest request, Owner owner) {
        Pet pet = new Pet();
        pet.setName(request.name());
        pet.setGender(request.gender());
        pet.setDateOfBirth(request.dateOfBirth());
        pet.setAnimalKind(request.animalKind());
        pet.setWeight(request.weight());
        pet.setOwner(owner);
        return pet;
    }

    public static PetResponse toResponse(Pet pet) {
        return new PetResponse(
                pet.getId(),
                pet.getName(),
                pet.getGender(),
                pet.getDateOfBirth(),
                pet.getAnimalKind(),
                pet.getWeight(),
                pet.getOwner().getId()
        );
    }
}


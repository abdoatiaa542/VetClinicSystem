package com.example.Vet.Clinic.System.controller;

import com.example.Vet.Clinic.System.dto.PetRequest;
import com.example.Vet.Clinic.System.service.PetService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;
    private static final Logger log = LoggerFactory.getLogger(PetController.class);

    @PostMapping
    public ResponseEntity<?> addPet(@RequestBody PetRequest request) {
        log.info("Adding new pet: {}", request.name());
        return ResponseEntity.ok(petService.addPet(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPetById(@PathVariable Long id) {
        log.info("Fetching pet with ID: {}", id);
        return ResponseEntity.ok(petService.getPetById(id));
    }
}

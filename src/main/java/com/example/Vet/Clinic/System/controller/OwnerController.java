package com.example.Vet.Clinic.System.controller;

import com.example.Vet.Clinic.System.service.owner.OwnerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;
    private static final Logger log = LoggerFactory.getLogger(OwnerController.class);

//    @PostMapping
//    public ResponseEntity<?> addOwner(@RequestBody OwnerRequest request) {
//        log.info("Adding new owner: {}", request.name());
//        return ResponseEntity.ok(ownerService.addOwner(request));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOwnerById(@PathVariable Long id) {
        log.info("Fetching owner with ID: {}", id);
        return ResponseEntity.ok(ownerService.getOwnerById(id));
    }

    @GetMapping("/{id}/pets")
    public ResponseEntity<?> getOwnerPets(@PathVariable Long id) {
        log.info("Fetching pets for owner ID: {}", id);
        return ResponseEntity.ok(ownerService.getOwnerPets(id));
    }
}

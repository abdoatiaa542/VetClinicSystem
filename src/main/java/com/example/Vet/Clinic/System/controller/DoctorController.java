package com.example.Vet.Clinic.System.controller;

import com.example.Vet.Clinic.System.dto.DoctorRequest;
import com.example.Vet.Clinic.System.service.doctor.DoctorService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private static final Logger log = LoggerFactory.getLogger(DoctorController.class);

//    @PostMapping
//    public ResponseEntity<?> addDoctor(@RequestBody DoctorRequest request) {
//        log.info("Adding new doctor: {}", request.name());
//        return ResponseEntity.ok(doctorService.addDoctor(request));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) {
        log.info("Fetching doctor with ID: {}", id);
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PutMapping("/{id}/assign/{clinicId}")
    public ResponseEntity<?> assignDoctorToClinic(@PathVariable Long id, @PathVariable Long clinicId) {
        log.info("Assigning doctor {} to clinic {}", id, clinicId);
        return ResponseEntity.ok(doctorService.assignToClinic(id, clinicId));
    }

    @PutMapping("/{id}/deassign")
    public ResponseEntity<?> deAssignDoctorFromClinic(@PathVariable Long id) {
        log.info("De-assigning doctor {} from clinic", id);
        return ResponseEntity.ok(doctorService.deAssignFromClinic(id));
    }
}

package com.example.Vet.Clinic.System.controller;


import com.example.Vet.Clinic.System.dto.ClinicRequest;
import com.example.Vet.Clinic.System.service.clinic.ClinicService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clinics")
@RequiredArgsConstructor
public class ClinicController {
    private final ClinicService clinicService;
    private static final Logger log = LoggerFactory.getLogger(ClinicController.class);


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addClinic(@RequestBody ClinicRequest request) {
        log.info("Adding new clinic: {}", request.name());
        return ResponseEntity.ok(clinicService.addClinic(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClinicById(@PathVariable Long id) {
        log.info("Fetching clinic with ID: {}", id);
        return ResponseEntity.ok(clinicService.getClinicById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchClinic(@RequestParam(required = false) String phone,
                                          @RequestParam(required = false) String address) {
        log.info("Searching clinics by phone: {} or address: {}", phone, address);
        return ResponseEntity.ok(clinicService.searchClinic(phone, address));
    }

    @GetMapping("/{id}/doctors")
    public ResponseEntity<?> getClinicDoctors(@PathVariable Long id) {
        log.info("Fetching doctors for clinic ID: {}", id);
        return ResponseEntity.ok(clinicService.getClinicDoctors(id));
    }

//    @PutMapping("/{clinicId}/assign/{doctorId}")
//    public ResponseEntity<?> assignDoctor(@PathVariable Long clinicId, @PathVariable Long doctorId) {
//        log.info("Assigning doctor {} to clinic {}", doctorId, clinicId);
//        return ResponseEntity.ok(clinicService.assignDoctor(clinicId, doctorId));
//    }
//
//    @PutMapping("/deassign/{doctorId}")
//    public ResponseEntity<?> deAssignDoctor(@PathVariable Long doctorId) {
//        log.info("De-assigning doctor {}", doctorId);
//        return ResponseEntity.ok(clinicService.deAssignDoctor(doctorId));
//    }
}

package com.example.Vet.Clinic.System.controller;


import com.example.Vet.Clinic.System.dto.LoginRequest;
import com.example.Vet.Clinic.System.dto.RegistrationRequest;
import com.example.Vet.Clinic.System.service.auth.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService service;
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest request) {
        log.info("Login attempt for username: {}", request.username());
        return ResponseEntity.accepted().body(service.loginUser(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@RequestParam(value = "device-token", required = false) String deviceToken) {
        log.info("Logout attempt. Device token: {}", deviceToken);
        return ResponseEntity.accepted().body(service.logoutUser(deviceToken));
    }

    @PostMapping("/register/admin")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody RegistrationRequest request) {
        log.info("Registering new Admin: {}", request.username());
        return ResponseEntity.created(URI.create("/api/v1/auth/user-registration"))
                .body(service.registerAdmin(request));
    }

    @PostMapping("/register/owner")
    public ResponseEntity<?> registerOwner(@Valid @RequestBody RegistrationRequest request) {
        log.info("Registering new Librarian: {}", request.username());
        return ResponseEntity.created(URI.create("/api/v1/auth/user-registration"))
                .body(service.registerOwner(request));
    }

    @PostMapping("/register/Doctor")
    public ResponseEntity<?> registerDoctor(@Valid @RequestBody RegistrationRequest request) {
        log.info("Registering new User: {}", request.username());
        return ResponseEntity.created(URI.create("/api/v1/auth/user-registration"))
                .body(service.registerDoctor(request));
    }
}


package com.example.Vet.Clinic.System.dto;

public record LoginResponse(
    String token,
    String refreshToken
) {
}

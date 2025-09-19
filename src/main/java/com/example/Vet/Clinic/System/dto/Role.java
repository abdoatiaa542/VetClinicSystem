package com.example.Vet.Clinic.System.dto;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, OWNER , DOCTOR;

    @Override
    public String getAuthority() {
        return name();
    }

}
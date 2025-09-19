package com.example.Vet.Clinic.System.mapper;

import com.example.Vet.Clinic.System.dto.ClinicRequest;
import com.example.Vet.Clinic.System.dto.ClinicResponse;
import com.example.Vet.Clinic.System.model.Clinic;

import java.util.stream.Collectors;

public class ClinicMapper {

    public static Clinic toEntity(ClinicRequest request) {
        Clinic clinic = new Clinic();
        clinic.setName(request.name());
        clinic.setAddress(request.address());
        clinic.setPhone(request.phone());
        clinic.setEmail(request.email());
        clinic.setFacebookUrl(request.facebookUrl());
        clinic.setInstagramUrl(request.instagramUrl());
        clinic.setWebsiteUrl(request.websiteUrl());
        clinic.setWorkingDays(request.workingDays());
        clinic.setOpenHour(request.openHour());
        clinic.setCloseHour(request.closeHour());
        return clinic;
    }

    public static ClinicResponse toResponse(Clinic clinic) {
        return new ClinicResponse(
                clinic.getId(),
                clinic.getName(),
                clinic.getAddress(),
                clinic.getPhone(),
                clinic.getEmail(),
                clinic.getFacebookUrl(),
                clinic.getInstagramUrl(),
                clinic.getWebsiteUrl(),
                clinic.getWorkingDays().stream()
                        .map(Enum::name)
                        .collect(Collectors.toSet()),
                clinic.getOpenHour(),
                clinic.getCloseHour()
        );
    }
}



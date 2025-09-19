package com.example.Vet.Clinic.System.mapper;

import com.example.Vet.Clinic.System.dto.DoctorRequest;
import com.example.Vet.Clinic.System.dto.DoctorResponse;
import com.example.Vet.Clinic.System.model.Clinic;
import com.example.Vet.Clinic.System.model.users.Doctor;

public class DoctorMapper {

    public static Doctor toEntity(DoctorRequest request, Clinic clinic) {
        Doctor doctor = new Doctor();
        doctor.setUsername(request.name());
        doctor.setPhone(request.phone());
        doctor.setEmail(request.email());
        doctor.setClinic(clinic);
        return doctor;
    }

    public static DoctorResponse toResponse(Doctor doctor) {
        return new DoctorResponse(
                doctor.getId(),
                doctor.getUsername(),
                doctor.getPhone(),
                doctor.getEmail(),
                doctor.getPhoto(),
                doctor.getBio(),
                doctor.getClinic() != null ? doctor.getClinic().getId() : null
        );
    }
}

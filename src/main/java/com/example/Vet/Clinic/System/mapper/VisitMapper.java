package com.example.Vet.Clinic.System.mapper;


import com.example.Vet.Clinic.System.dto.VisitRequest;
import com.example.Vet.Clinic.System.dto.VisitResponse;
import com.example.Vet.Clinic.System.model.Clinic;
import com.example.Vet.Clinic.System.model.Pet;
import com.example.Vet.Clinic.System.model.Visit;
import com.example.Vet.Clinic.System.model.users.Doctor;

public class VisitMapper {

    public static Visit toEntity(VisitRequest request, Pet pet, Doctor doctor, Clinic clinic) {
        Visit visit = new Visit();
        visit.setPet(pet);
        visit.setDoctor(doctor);
        visit.setClinic(clinic);
        visit.setDate(request.date());
        return visit;
    }

    public static VisitResponse toResponse(Visit visit) {
        return new VisitResponse(
                visit.getId(),
                visit.getPet().getId(),
                visit.getDoctor().getId(),
                visit.getClinic().getId(),
                visit.getDate()
        );
    }
}

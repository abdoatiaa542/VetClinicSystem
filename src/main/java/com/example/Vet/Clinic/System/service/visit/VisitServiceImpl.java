package com.example.Vet.Clinic.System.service.visit;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import com.example.Vet.Clinic.System.dto.VisitRequest;
import com.example.Vet.Clinic.System.exception.ResourceNotFoundException;
import com.example.Vet.Clinic.System.mapper.VisitMapper;
import com.example.Vet.Clinic.System.model.Clinic;
import com.example.Vet.Clinic.System.model.Pet;
import com.example.Vet.Clinic.System.model.Visit;
import com.example.Vet.Clinic.System.model.users.Doctor;
import com.example.Vet.Clinic.System.repository.ClinicRepository;
import com.example.Vet.Clinic.System.repository.DoctorRepository;
import com.example.Vet.Clinic.System.repository.PetRepository;
import com.example.Vet.Clinic.System.repository.VisitRepository;
import com.example.Vet.Clinic.System.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final PetRepository petRepository;
    private final DoctorRepository doctorRepository;
    private final ClinicRepository clinicRepository;

    @Override
    public ApiResponse addVisit(VisitRequest request) {
        Pet pet = petRepository.findById(request.petId())
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found"));

        Doctor doctor = doctorRepository.findById(request.doctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

        Clinic clinic = clinicRepository.findById(request.clinicId())
                .orElseThrow(() -> new ResourceNotFoundException("Clinic not found"));

        Visit visit = VisitMapper.toEntity(request, pet, doctor, clinic);
        Visit saved = visitRepository.save(visit);
        return ApiResponse.of("Visit created successfully", VisitMapper.toResponse(saved));
    }

    @Override
    public ApiResponse getVisitById(Long id) {
        Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visit not found"));
        return ApiResponse.of("Visit fetched successfully", VisitMapper.toResponse(visit));
    }
}

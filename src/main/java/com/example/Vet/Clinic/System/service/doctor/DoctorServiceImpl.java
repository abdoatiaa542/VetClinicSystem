package com.example.Vet.Clinic.System.service.doctor;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import com.example.Vet.Clinic.System.exception.ResourceNotFoundException;
import com.example.Vet.Clinic.System.mapper.DoctorMapper;
import com.example.Vet.Clinic.System.model.Clinic;
import com.example.Vet.Clinic.System.model.users.Doctor;
import com.example.Vet.Clinic.System.repository.ClinicRepository;
import com.example.Vet.Clinic.System.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ClinicRepository clinicRepository;

//    @Override
//    public ApiResponse addDoctor(DoctorRequest request) {
//        Doctor doctor = DoctorMapper.toEntity(request, null);
//        Doctor saved = doctorRepository.save(doctor);
//        return ApiResponse.of("Doctor created successfully", DoctorMapper.toResponse(saved));
//    }

    @Override
    public ApiResponse getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        return ApiResponse.of("Doctor fetched successfully", DoctorMapper.toResponse(doctor));
    }

    @Override
    public ApiResponse assignToClinic(Long doctorId, Long clinicId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        Clinic clinic = clinicRepository.findById(clinicId)
                .orElseThrow(() -> new ResourceNotFoundException("Clinic not found"));
        doctor.setClinic(clinic);
        doctorRepository.save(doctor);
        return ApiResponse.of("Doctor assigned to clinic successfully");
    }

    @Override
    public ApiResponse deAssignFromClinic(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        doctor.setClinic(null);
        doctorRepository.save(doctor);
        return ApiResponse.of("Doctor de-assigned from clinic successfully");
    }
}

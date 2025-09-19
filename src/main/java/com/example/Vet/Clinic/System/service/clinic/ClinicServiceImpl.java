package com.example.Vet.Clinic.System.service.clinic;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import com.example.Vet.Clinic.System.dto.ClinicRequest;
import com.example.Vet.Clinic.System.dto.ClinicResponse;
import com.example.Vet.Clinic.System.dto.DoctorResponse;
import com.example.Vet.Clinic.System.exception.ResourceNotFoundException;
import com.example.Vet.Clinic.System.mapper.ClinicMapper;
import com.example.Vet.Clinic.System.mapper.DoctorMapper;
import com.example.Vet.Clinic.System.model.Clinic;
import com.example.Vet.Clinic.System.model.users.Doctor;
import com.example.Vet.Clinic.System.repository.ClinicRepository;
import com.example.Vet.Clinic.System.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository clinicRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public ApiResponse addClinic(ClinicRequest request) {
        Clinic clinic = ClinicMapper.toEntity(request);
        Clinic saved = clinicRepository.save(clinic);
        return ApiResponse.of("Clinic created successfully", ClinicMapper.toResponse(saved));
    }

    @Override
    public ApiResponse getClinicById(Long id) {
        Clinic clinic = clinicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clinic not found"));
        return ApiResponse.of("Clinic fetched successfully", ClinicMapper.toResponse(clinic));
    }

    @Override
    public ApiResponse searchClinic(String phone, String address) {
        if (phone != null) {
            Clinic clinic = clinicRepository.findByPhone(phone)
                    .orElseThrow(() -> new ResourceNotFoundException("Clinic not found with phone: " + phone));
            return ApiResponse.of("Clinic found", ClinicMapper.toResponse(clinic));
        } else if (address != null) {
            List<ClinicResponse> clinics = clinicRepository.findByAddressContainingIgnoreCase(address)
                    .stream().map(ClinicMapper::toResponse).collect(Collectors.toList());
            return ApiResponse.of("Clinics found", clinics);
        }
        return ApiResponse.of("Please provide phone or address to search");
    }

    @Override
    public ApiResponse getClinicDoctors(Long clinicId) {
        List<DoctorResponse> doctors = doctorRepository.findByClinicId(clinicId)
                .stream().map(DoctorMapper::toResponse).collect(Collectors.toList());
        return ApiResponse.of("Doctors fetched successfully", doctors);
    }

//    @Override
//    public ApiResponse assignDoctor(Long clinicId, Long doctorId) {
//        Clinic clinic = clinicRepository.findById(clinicId)
//                .orElseThrow(() -> new ResourceNotFoundException("Clinic not found"));
//        Doctor doctor = doctorRepository.findById(doctorId)
//                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
//        doctor.setClinic(clinic);
//        doctorRepository.save(doctor);
//        return ApiResponse.of("Doctor assigned to clinic successfully", DoctorMapper.toResponse(doctor));
//    }
//
//    @Override
//    public ApiResponse deAssignDoctor(Long doctorId) {
//        Doctor doctor = doctorRepository.findById(doctorId)
//                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
//        doctor.setClinic(null);
//        doctorRepository.save(doctor);
//        return ApiResponse.of("Doctor de-assigned from clinic successfully", DoctorMapper.toResponse(doctor));
//    }
}
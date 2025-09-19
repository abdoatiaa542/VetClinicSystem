package com.example.Vet.Clinic.System.service.clinic;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import com.example.Vet.Clinic.System.dto.ClinicRequest;

public interface ClinicService {
    ApiResponse addClinic(ClinicRequest request);
    ApiResponse getClinicById(Long id);
    ApiResponse searchClinic(String phone, String address);
    ApiResponse getClinicDoctors(Long clinicId);
//    ApiResponse assignDoctor(Long clinicId, Long doctorId);
//    ApiResponse deAssignDoctor(Long doctorId);
}
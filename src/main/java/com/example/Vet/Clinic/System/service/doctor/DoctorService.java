package com.example.Vet.Clinic.System.service.doctor;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import com.example.Vet.Clinic.System.dto.DoctorRequest;

public interface DoctorService {
//    ApiResponse addDoctor(DoctorRequest request);
    ApiResponse getDoctorById(Long id);
    ApiResponse assignToClinic(Long doctorId, Long clinicId);
    ApiResponse deAssignFromClinic(Long doctorId);
}

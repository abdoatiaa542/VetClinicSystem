package com.example.Vet.Clinic.System.service;

import com.example.Vet.Clinic.System.dto.ApiResponse;
import com.example.Vet.Clinic.System.dto.VisitRequest;

public interface VisitService {
    ApiResponse addVisit(VisitRequest request);
    ApiResponse getVisitById(Long id);
}
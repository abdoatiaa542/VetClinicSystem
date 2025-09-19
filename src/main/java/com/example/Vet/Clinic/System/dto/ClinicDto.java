package com.example.Vet.Clinic.System.dto;

import com.example.Vet.Clinic.System.model.DayOfWeek;

import java.time.LocalTime;
import java.util.Set;

public record ClinicDto(
        Long id,
        String name,
        String address,
        String phone,
        Set<DayOfWeek> workingDays,
        LocalTime openHour,
        LocalTime closeHour,
        String email,
        String socialUrls
) {}

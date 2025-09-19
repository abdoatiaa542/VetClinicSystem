package com.example.Vet.Clinic.System.repository;

import com.example.Vet.Clinic.System.model.users.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByClinicId(Long clinicId);
}
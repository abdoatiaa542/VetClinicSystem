package com.example.Vet.Clinic.System.repository;

import com.example.Vet.Clinic.System.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    Optional<Clinic> findByPhone(String phone);
    List<Clinic> findByAddressContainingIgnoreCase(String address);
}
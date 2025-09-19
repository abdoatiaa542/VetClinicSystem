package com.example.Vet.Clinic.System.repository;

import com.example.Vet.Clinic.System.model.users.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {}

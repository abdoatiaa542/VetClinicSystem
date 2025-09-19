package com.example.Vet.Clinic.System.repository;

import com.example.Vet.Clinic.System.model.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {
}

package com.example.Vet.Clinic.System.service.auth;

import com.example.Vet.Clinic.System.dto.RegistrationRequest;
import org.springframework.lang.Nullable;


public interface IAuthService {

    Object loginUser(Object object);

    Object logoutUser(@Nullable String deviceToken);

    Object registerAdmin(RegistrationRequest request);

    Object registerDoctor(RegistrationRequest request);

    Object registerOwner(RegistrationRequest request);
}

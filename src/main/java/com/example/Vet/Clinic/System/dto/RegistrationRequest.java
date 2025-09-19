package com.example.Vet.Clinic.System.dto;


import com.example.Vet.Clinic.System.annotation.UserUnique;
import com.example.Vet.Clinic.System.annotation.UserUniqueConstraint;
import com.example.Vet.Clinic.System.constant.RegexConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegistrationRequest(


        @Email
        @NotBlank
        @UserUnique(constraint = UserUniqueConstraint.EMAIL)
        String email,
        @NotBlank
        @UserUnique(constraint = UserUniqueConstraint.USERNAME)
        String username,
        @NotBlank
        @Pattern(regexp = RegexConstants.PASSWORD)
        String password
) {

}
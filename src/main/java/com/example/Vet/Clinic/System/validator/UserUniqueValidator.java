package com.example.Vet.Clinic.System.validator;

import com.example.Vet.Clinic.System.annotation.UserUnique;
import com.example.Vet.Clinic.System.annotation.UserUniqueConstraint;
import com.example.Vet.Clinic.System.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class UserUniqueValidator implements ConstraintValidator<UserUnique, String> {
    private UserUniqueConstraint uniqueConstraint;
    private final UserRepository repository;

    @Override
    public void initialize(UserUnique constraintAnnotation) {
        uniqueConstraint = constraintAnnotation.constraint();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return Objects.isNull(value) ||
                switch (uniqueConstraint) {
                    case EMAIL -> !repository.existsByEmailIgnoreCase(value.strip());
                    case USERNAME -> !repository.existsByUsernameIgnoreCase(value.strip());
                };
    }
}
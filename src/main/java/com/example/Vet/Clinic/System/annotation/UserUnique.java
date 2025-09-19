package com.example.Vet.Clinic.System.annotation;

import com.example.Vet.Clinic.System.validator.UserUniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@Constraint(validatedBy = UserUniqueValidator.class)
public @interface UserUnique {
    UserUniqueConstraint constraint();

    String message() default "this value is already used";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
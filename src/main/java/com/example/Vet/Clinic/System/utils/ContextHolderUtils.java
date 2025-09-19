package com.example.Vet.Clinic.System.utils;


import com.example.Vet.Clinic.System.model.users.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class ContextHolderUtils {

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Object getPrincipal() {
        Objects.requireNonNull(getAuthentication());
        return getAuthentication().getPrincipal();
    }

    public static User getUser() {
        Objects.requireNonNull(getPrincipal());
        if (getPrincipal() instanceof User user) {
            return user;
        }
        throw new IllegalStateException();
    }


}
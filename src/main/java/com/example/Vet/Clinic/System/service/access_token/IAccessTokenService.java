package com.example.Vet.Clinic.System.service.access_token;

import com.example.Vet.Clinic.System.model.AccessToken;
import com.example.Vet.Clinic.System.model.users.User;

public interface IAccessTokenService {
    AccessToken create(User user);

    AccessToken get(String token);

    boolean exists(String token);

    void delete(String token);

    AccessToken refresh(User user);
}
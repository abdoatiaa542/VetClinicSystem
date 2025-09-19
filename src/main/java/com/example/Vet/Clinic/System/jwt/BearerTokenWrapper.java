package com.example.Vet.Clinic.System.jwt;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class BearerTokenWrapper {

    private String token;

}

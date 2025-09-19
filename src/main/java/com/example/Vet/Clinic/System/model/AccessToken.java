package com.example.Vet.Clinic.System.model;

import com.example.Vet.Clinic.System.model.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ACCESS_TOKENS")
public class AccessToken {
    @Id
    @Column(length = 512)
    private String token;

    @Column(nullable = false, updatable = false)
    private Date expiration;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private User user;
}
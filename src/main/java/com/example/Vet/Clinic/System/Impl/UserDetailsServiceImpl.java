package com.example.Vet.Clinic.System.Impl;

import com.example.Vet.Clinic.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.loadByUsernameOrEmail(username.strip())
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with this email or username %s not found."
                                .formatted(username)
                ));
    }
}
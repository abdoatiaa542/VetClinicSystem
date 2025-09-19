package com.example.Vet.Clinic.System.repository;


import com.example.Vet.Clinic.System.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = """
            SELECT u
            FROM User u
            WHERE LOWER(u.username) LIKE LOWER(:username)
            OR LOWER(u.email) LIKE LOWER(:username)
            """)
    Optional<User> findByUsernameOrEmail(@Param("username") String username);

    @Query(value = """
            SELECT u
            FROM User u
            WHERE LOWER(u.username) LIKE LOWER(:username)
            OR LOWER(u.email) LIKE LOWER(:username)""")
    Optional<User> loadByUsernameOrEmail(@Param("username") String username);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByUsernameIgnoreCase(String username);


}

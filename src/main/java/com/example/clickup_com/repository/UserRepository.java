package com.example.clickup_com.repository;

import com.example.clickup_com.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findByUsernameAndEmailCode(String username, String emailCode);
}

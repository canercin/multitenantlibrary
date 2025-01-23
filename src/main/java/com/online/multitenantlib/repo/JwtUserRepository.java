package com.online.multitenantlib.repo;

import com.online.multitenantlib.model.JwtUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JwtUserRepository extends JpaRepository<JwtUserDetails, UUID> {
    Optional<JwtUserDetails> findByEmail(String email);
}

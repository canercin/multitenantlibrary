package com.online.multitenantlib.repo;

import com.online.multitenantlib.model.JwtUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JwtUserRepository extends JpaRepository<JwtUserDetails, UUID> {
    Optional<JwtUserDetails> findByEmail(String email);

    Optional<JwtUserDetails> findByUsername(String username);
}

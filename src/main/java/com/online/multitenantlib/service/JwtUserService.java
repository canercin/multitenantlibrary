package com.online.multitenantlib.service;

import com.online.multitenantlib.model.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface JwtUserService {
    List<JwtUserDetails> getAllUsers();
    Optional<JwtUserDetails> getUserByMail(String email);
    JwtUserDetails saveUser(JwtUserDetails jwtUserDetails);
    JwtUserDetails updateUser(JwtUserDetails jwtUserDetails);
    void deleteUser(JwtUserDetails jwtUserDetails);
    UserDetailsService userDetailsService();

    Optional<JwtUserDetails> getUserByUsername(String email);
}

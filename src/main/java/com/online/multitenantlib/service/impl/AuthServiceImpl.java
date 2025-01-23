package com.online.multitenantlib.service.impl;

import com.online.multitenantlib.dto.JwtResponse;
import com.online.multitenantlib.dto.LoginRequest;
import com.online.multitenantlib.dto.RegisterRequest;
import com.online.multitenantlib.enums.Role;
import com.online.multitenantlib.model.JwtUserDetails;
import com.online.multitenantlib.repo.JwtUserRepository;
import com.online.multitenantlib.service.AuthService;
import com.online.multitenantlib.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private JwtUserRepository userRepository;
    private AuthenticationManager authenticationManager;

    @Override
    public JwtUserDetails register(RegisterRequest registerRequest) {
        JwtUserDetails userDetails = new JwtUserDetails();
        userDetails.setUsername(registerRequest.getEmail());
        userDetails.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userDetails.setFirstName(registerRequest.getFirstName());
        userDetails.setLastName(registerRequest.getLastName());
        userDetails.setRole((registerRequest.getAuthorities().equalsIgnoreCase("ROLE_ADMIN")) ? Role.ROLE_ADMIN : Role.ROLE_USER);

        return userRepository.save(userDetails);
    }

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        JwtUserDetails userDetails = userRepository.findByEmail(loginRequest.getEmail()).orElse(null);
        return JwtResponse.builder().jwtToken(jwtService.generateToken(userDetails)).build();
    }
}

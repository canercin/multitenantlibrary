package com.online.multitenantlib.controller;

import com.online.multitenantlib.dto.JwtResponse;
import com.online.multitenantlib.dto.LoginRequest;
import com.online.multitenantlib.dto.RegisterRequest;
import com.online.multitenantlib.model.JwtUserDetails;
import com.online.multitenantlib.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/signup")
    public JwtUserDetails signup(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }
}

package com.online.multitenantlib.service;

import com.online.multitenantlib.dto.JwtResponse;
import com.online.multitenantlib.dto.LoginRequest;
import com.online.multitenantlib.dto.RegisterRequest;
import com.online.multitenantlib.model.JwtUserDetails;

public interface AuthService {
    JwtUserDetails register(RegisterRequest registerRequest);
    JwtResponse login(LoginRequest loginRequest);
}

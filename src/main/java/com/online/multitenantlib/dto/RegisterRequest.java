package com.online.multitenantlib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String authorities;
}

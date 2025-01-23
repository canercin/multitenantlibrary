package com.online.multitenantlib.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class JwtResponse {
    private String jwtToken;
}

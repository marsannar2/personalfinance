package com.marsannar2.personalfinance.dto.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
public class LoginRequest {

    @Column(length = 128,nullable=false,unique=true)
    @NotBlank
    private String username;

    @Column(length = 128,nullable=false)
    @NotBlank
    private String password;

    
}

package com.marsannar2.personalfinance.dto.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.marsannar2.personalfinance.user.AppUser;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInRequest {

    @Column(length = 128,nullable=false,unique=true)
    @NotBlank
    private String username;

    @Column(length = 128,nullable=false)
    @NotBlank
    private String password;

    @Email
    @Column(nullable=false,unique=true)
    private String email;

    public AppUser toUser(){
        AppUser user = new AppUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }
    
}

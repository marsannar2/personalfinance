package com.marsannar2.personalfinance.user;

import com.marsannar2.personalfinance.models.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="appusers")
public class User extends BaseEntity{

    @Column(length = 128,nullable=false,unique=true)
    @NotBlank
    private String username;

    @Column(length = 128,nullable=false)
    @NotBlank
    private String password;

    @Email
    @Column(nullable=false,unique=true)
    private String email;

    
}

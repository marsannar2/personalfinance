package com.marsannar2.personalfinance.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class AppUser extends BaseEntity implements UserDetails{

    @Column(length = 128,nullable=false,unique=true)
    @NotBlank
    private String username;

    @Column(length = 128,nullable=false)
    @NotBlank
    private String password;

    @Email
    @Column(nullable=false,unique=true)
    private String email;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    
}

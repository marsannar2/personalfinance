package com.marsannar2.personalfinance.configuration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.marsannar2.personalfinance.user.AppUser;
import com.marsannar2.personalfinance.user.AppUserService;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final AppUserService userService;

    public CustomUserDetailsService(AppUserService userService){
        this.userService = userService;
    }

     @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userService.findByUsername(username);

        if (user.getUsername().equals(username)) {
            return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

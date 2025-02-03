package com.marsannar2.personalfinance.user;



import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;



@Service
public class AppUserService implements UserDetailsService{

    private final AppUserRepository userRepository;

    public AppUserService(AppUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public AppUser findByUsername(String username){
        Optional<AppUser> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UsernameNotFoundException("User not found");
        }

    }

    @Transactional
    public AppUser register(AppUser user){
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username)
        .orElseThrow(()->new UsernameNotFoundException("user not found"));

        return User.withUsername(user.getUsername())
        .password(user.getPassword())
        .authorities(List.of()) 
        .build();
    }

    
}

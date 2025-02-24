package com.marsannar2.personalfinance.user;




import java.util.Optional;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






@Service
public class AppUserService{

    private final AppUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository userRepository,BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly=true)
    public AppUser findByUsername(String username){
        Optional<AppUser> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UsernameNotFoundException("User not found");
        }

    }

    @Transactional
    public void register(AppUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional(readOnly=true)
    public boolean userExists(String username){
        Optional<AppUser> user = userRepository.findByUsername(username);
        return user.isPresent();
    }

    
}

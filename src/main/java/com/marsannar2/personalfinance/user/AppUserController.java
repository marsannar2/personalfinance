package com.marsannar2.personalfinance.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.marsannar2.personalfinance.dto.user.RegisterUserDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/users")
public class AppUserController {

    private final AppUserService userService;

    public AppUserController(AppUserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AppUser> registerUser(@Valid @RequestBody RegisterUserDTO registerUserDto) {
        AppUser createdUser = userService.register(registerUserDto.toUser());
    
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    
}

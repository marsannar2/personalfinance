package com.marsannar2.personalfinance.user;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.marsannar2.personalfinance.dto.user.LoginRequest;
import com.marsannar2.personalfinance.dto.user.SignInRequest;
import com.marsannar2.personalfinance.utils.response.MessageResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/users")
public class AppUserController {

    private final AppUserService userService;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;

    public AppUserController(AppUserService userService,AuthenticationManager authenticationManager,BCryptPasswordEncoder passwordEncoder){
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignInRequest registerUserDto) {

        Boolean isAuthenticated = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();

        if(userService.userExists(registerUserDto.getUsername())){
            return ResponseEntity.badRequest().body(new MessageResponse("User already exists!"));
        }else if(isAuthenticated){
            return ResponseEntity.badRequest().body(
               new MessageResponse("You cant create another account logged in as another user!"));
        }else{
            userService.register(registerUserDto.toUser());
        }
        
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/login")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        try{
            AppUser user = userService.findByUsername(loginRequest.getUsername());

            if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
                return ResponseEntity.badRequest().body(new MessageResponse(" Incorrect password, try again "));
                
            }else{
                Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.getUsername(), loginRequest.getPassword());

                Authentication authenticationResponse = authenticationManager.authenticate(authenticationRequest);
                SecurityContextHolder.getContext().setAuthentication(authenticationResponse);

                return new ResponseEntity<>(authenticationResponse,HttpStatus.ACCEPTED);

            }
        }catch(BadCredentialsException exception){
            return ResponseEntity.badRequest().body("Bad Credentials!");
        }

    }
    
}

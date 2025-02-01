package com.marsannar2.personalfinance.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.marsannar2.personalfinance.configuration.jwt.JwtAuthenticationFilter;
import com.marsannar2.personalfinance.user.AppUserService;

import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public WebSecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((requests) -> {
                requests.requestMatchers("/signup","/home").permitAll();
                requests.anyRequest().authenticated();
            }
            );

            return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("http://localhost:8005"));
        configuration.setAllowedMethods(List.of("GET","POST"));
        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**",configuration);

        return source;
    }


}

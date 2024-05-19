package com.example.complexeSportif.security;

import com.example.complexeSportif.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepo userRepo;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepo.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found !!"));
    }
}

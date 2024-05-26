package com.example.complexeSportif.services.auth;

import com.example.complexeSportif.entities.auth.*;
import com.example.complexeSportif.repositories.TokenRepo;
import com.example.complexeSportif.repositories.UserRepo;
import com.example.complexeSportif.security.ApplicationConfig;
import com.example.complexeSportif.security.JwtAuthenticationFilter;
import com.example.complexeSportif.security.JwtService;
import com.example.complexeSportif.services.email.EmailService;
import com.example.complexeSportif.services.email.EmailTemplateName;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder   passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;
    private final TokenRepo tokenRepo;
@Value("${mailing.frontend.activation-url}")
    private String activationUrl;
    public AuthenticationResponse register(RegisterRequest request) throws MessagingException {
        var user= User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        userRepo.save(user);
        sendValidationEmail(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken=generateAndSaveActivationToken(user);
        // sending email confirmation
        emailService.sendEmail(
                user.getEmail(),
                user.fullName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account Activation"
        );
    }

    private String generateAndSaveActivationToken(User user) {
        // generate token
        String generateToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generateToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(60))
                .user(user)
                .build();
                tokenRepo.save(token);
        return generateToken;
    }
    // generate an activation code composed of  6 digits
    private String generateActivationCode(int length) {
        String characters ="0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom =new SecureRandom();
        for (int i =0; i< length; i++){
            int randomIndex= secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return  codeBuilder.toString();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepo.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Transactional
    public void activateAccount(String token) throws MessagingException {
        Token savedToken = tokenRepo.findByToken(token)
                // todo exception has to be defined
                .orElseThrow(()-> new RuntimeException("Invalid token"));
        if(LocalDateTime.now().isAfter(savedToken.getExpiresAt())){
            sendValidationEmail(savedToken.getUser());
            throw new RuntimeException("Activation token has expired. A new tken has been sent to the same email adress");
        }
        var user=userRepo.findById(savedToken.getUser().getId())
                .orElseThrow(()-> new UsernameNotFoundException("User not found "));
        user.setEnabled(true);
        userRepo.save(user);
        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepo.save(savedToken);
    }
}

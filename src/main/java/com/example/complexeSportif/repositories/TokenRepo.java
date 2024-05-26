package com.example.complexeSportif.repositories;

import com.example.complexeSportif.entities.auth.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Integer> {

    Optional<Token> findByToken(String token);
}

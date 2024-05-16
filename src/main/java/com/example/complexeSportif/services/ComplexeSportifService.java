package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.ComplexeSportif;

import java.util.List;
import java.util.Optional;

public interface ComplexeSportifService {


    List<ComplexeSportif> getAllComplexeSportifs();

    Optional<ComplexeSportif> getComplexeSportifById(Long id);

    ComplexeSportif saveComplexeSportif(ComplexeSportif complexeSportif);

    void deleteComplexeSportif(Long id);
}

package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.ComplexeSportif;
import com.example.complexeSportif.repositories.ComplexeSportifRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComplexeSportifServiceImp implements ComplexeSportifService {
    @Autowired
    private ComplexeSportifRepo complexeSportifRepo;
    @Override
    public List<ComplexeSportif> getAllComplexeSportifs() {
        return complexeSportifRepo.findAll();
    }
    @Override

    public Optional<ComplexeSportif> getComplexeSportifById(Long id) {
        return complexeSportifRepo.findById(id);
    }
    @Override

    public ComplexeSportif saveComplexeSportif(ComplexeSportif complexeSportif) {
        return complexeSportifRepo.save(complexeSportif);
    }
    @Override

    public void deleteComplexeSportif(Long id) {
        complexeSportifRepo.deleteById(id);
    }
}

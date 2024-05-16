package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.SalleMuscu;
import com.example.complexeSportif.repositories.SalleMuscuRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalleMuscuServiceImp implements SalleMuscuService {
    @Autowired
    private SalleMuscuRepo salleMuscuRepo;
    @Override
    public List<SalleMuscu> getAllSalleMuscu() {
        return salleMuscuRepo.findAll();
    }
    @Override

    public Optional<SalleMuscu> getSalleMuscuById(Long id) {
        return salleMuscuRepo.findById(id);
    }
    @Override

    public SalleMuscu saveSalleMuscu(SalleMuscu salleMuscu) {
        return salleMuscuRepo.save(salleMuscu);
    }
    @Override

    public void deleteSalleMuscu(Long id) {
        salleMuscuRepo.deleteById(id);
    }
}

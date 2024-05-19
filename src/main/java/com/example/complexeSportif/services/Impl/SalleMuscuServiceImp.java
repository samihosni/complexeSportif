package com.example.complexeSportif.services.Impl;

import com.example.complexeSportif.entities.SalleMuscu;
import com.example.complexeSportif.repositories.SalleMuscuRepo;
import com.example.complexeSportif.services.SalleMuscuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalleMuscuServiceImp implements SalleMuscuService {

    private final SalleMuscuRepo salleMuscuRepo;
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

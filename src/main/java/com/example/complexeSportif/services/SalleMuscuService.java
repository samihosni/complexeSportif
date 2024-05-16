package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.SalleMuscu;

import java.util.List;
import java.util.Optional;

public interface SalleMuscuService {
    List<SalleMuscu> getAllSalleMuscu();

    Optional<SalleMuscu> getSalleMuscuById(Long id);


    SalleMuscu saveSalleMuscu(SalleMuscu salleMuscu);

    void deleteSalleMuscu(Long id);
}

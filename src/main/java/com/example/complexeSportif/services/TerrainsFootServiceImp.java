package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.Subscriptions;
import com.example.complexeSportif.entities.TerrainsFoot;
import com.example.complexeSportif.repositories.SubscriptionRepo;
import com.example.complexeSportif.repositories.TerrainsFootRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TerrainsFootServiceImp implements TerrainsFootService {
    @Autowired
    private TerrainsFootRepo terrainsFootRepo;
    @Override
    public List<TerrainsFoot> getAllTerrainsFoot() {
        return terrainsFootRepo.findAll();
    }
    @Override

    public Optional<TerrainsFoot> getTerrainsFootById(Long id) {
        return terrainsFootRepo.findById(id);
    }
    @Override

    public TerrainsFoot saveTerrainsFoot(TerrainsFoot terrainsFoot) {
        return terrainsFootRepo.save(terrainsFoot);
    }
    @Override

    public void deleteTerrainsFoot(Long id) {
        terrainsFootRepo.deleteById(id);
    }
}

package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.TerrainsPadel;
import com.example.complexeSportif.repositories.TerrainsPadelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TerrainsPadelServiceImp implements TerrainsPadelService {
    @Autowired
    private TerrainsPadelRepo terrainsPadelRepo;
    @Override
    public List<TerrainsPadel> getAllTerrainsPadel() {
        return terrainsPadelRepo.findAll();
    }
    @Override

    public Optional<TerrainsPadel> getSTerrainsPadelById(Long id) {
        return terrainsPadelRepo.findById(id);
    }
    @Override

    public TerrainsPadel saveTerrainsPadel(TerrainsPadel terrainsPadel) {
        return terrainsPadelRepo.save(terrainsPadel);
    }
    @Override

    public void deleteTerrainsPadel(Long id) {
        terrainsPadelRepo.deleteById(id);
    }

}

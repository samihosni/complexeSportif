package com.example.complexeSportif.services.Impl;

import com.example.complexeSportif.entities.TerrainsPadel;
import com.example.complexeSportif.repositories.TerrainsPadelRepo;
import com.example.complexeSportif.services.TerrainsPadelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TerrainsPadelServiceImp implements TerrainsPadelService {

    private final TerrainsPadelRepo terrainsPadelRepo;
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

package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.TerrainsFoot;

import java.util.List;
import java.util.Optional;

public interface TerrainsFootService {
    List<TerrainsFoot> getAllTerrainsFoot();

    Optional<TerrainsFoot> getTerrainsFootById(Long id);

    TerrainsFoot saveTerrainsFoot(TerrainsFoot terrainsFoot);

    void deleteTerrainsFoot(Long id);
}

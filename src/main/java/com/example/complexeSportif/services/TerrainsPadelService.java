package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.TerrainsPadel;

import java.util.List;
import java.util.Optional;

public interface TerrainsPadelService {
    List<TerrainsPadel> getAllTerrainsPadel();

    Optional<TerrainsPadel> getSTerrainsPadelById(Long id);

    TerrainsPadel saveTerrainsPadel(TerrainsPadel terrainsPadel);

    void deleteTerrainsPadel(Long id);
}

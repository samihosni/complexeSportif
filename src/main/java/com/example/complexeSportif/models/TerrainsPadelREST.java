package com.example.complexeSportif.models;

import com.example.complexeSportif.entities.TerrainsPadel;
import com.example.complexeSportif.services.TerrainsPadelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/terrainspadel")
@RequiredArgsConstructor
public class TerrainsPadelREST {

    private final TerrainsPadelService service;

    @GetMapping("/all")
    public List<TerrainsPadel> getAllTerrains() {
        return service.getAllTerrainsPadel();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TerrainsPadel> getTerrainById(@PathVariable Long id) {
        Optional<TerrainsPadel> terrain = service.getSTerrainsPadelById(id);
        return terrain.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public TerrainsPadel createTerrain(@RequestBody TerrainsPadel terrain) {
        return service.saveTerrainsPadel(terrain);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TerrainsPadel> updateTerrain(@PathVariable Long id, @RequestBody TerrainsPadel terrainDetails) {
        Optional<TerrainsPadel> optionalTerrain = service.getSTerrainsPadelById(id);
        if (optionalTerrain.isPresent()) {
            TerrainsPadel updatedTerrain = optionalTerrain.get();
            updatedTerrain.setName(terrainDetails.getName());
            updatedTerrain.setDispo(terrainDetails.getDispo());
            service.saveTerrainsPadel(updatedTerrain);
            return ResponseEntity.ok(updatedTerrain);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Long id) {
        Optional<TerrainsPadel> optionalTerrain = service.getSTerrainsPadelById(id);
        if (optionalTerrain.isPresent()) {
            service.deleteTerrainsPadel(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.complexeSportif.models;

import com.example.complexeSportif.entities.TerrainsFoot;
import com.example.complexeSportif.services.TerrainsFootService;
import com.example.complexeSportif.services.TerrainsPadelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/terrainsfoot")
@RequiredArgsConstructor
public class TerrainsFootREST {

    private final TerrainsFootService service;

    @GetMapping("/all")
    public List<TerrainsFoot> getAllTerrains() {
        return service.getAllTerrainsFoot();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TerrainsFoot> getTerrainById(@PathVariable Long id) {
        Optional<TerrainsFoot> terrain = service.getTerrainsFootById(id);
        return terrain.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public TerrainsFoot createTerrain(@RequestBody TerrainsFoot terrain) {
        return service.saveTerrainsFoot(terrain);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TerrainsFoot> updateTerrain(@PathVariable Long id, @RequestBody TerrainsFoot terrainDetails) {
        Optional<TerrainsFoot> optionalTerrain = service.getTerrainsFootById(id);
        if (optionalTerrain.isPresent()) {
            TerrainsFoot updatedTerrain = optionalTerrain.get();
            updatedTerrain.setName(terrainDetails.getName());
            updatedTerrain.setDispo(terrainDetails.getDispo());
            service.saveTerrainsFoot(updatedTerrain);
            return ResponseEntity.ok(updatedTerrain);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Long id) {
        Optional<TerrainsFoot> optionalTerrain = service.getTerrainsFootById(id);
        if (optionalTerrain.isPresent()) {
            service.deleteTerrainsFoot(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.complexeSportif.models;

import com.example.complexeSportif.entities.SalleMuscu;
import com.example.complexeSportif.services.SalleMuscuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("salle-muscu")
public class SalleMuscuREST {
    @Autowired
    private SalleMuscuService salleMuscuService;

    @GetMapping("/all")
    public ResponseEntity<List<SalleMuscu>> getAllSallesMuscu() {
        List<SalleMuscu> sallesMuscu = salleMuscuService.getAllSalleMuscu();
        return ResponseEntity.ok(sallesMuscu);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalleMuscu> getSalleMuscuById(@PathVariable Long id) {
        Optional<SalleMuscu> salleMuscu = salleMuscuService.getSalleMuscuById(id);
        return salleMuscu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SalleMuscu> createSalleMuscu(@RequestBody SalleMuscu salleMuscu) {
        SalleMuscu savedSalleMuscu = salleMuscuService.saveSalleMuscu(salleMuscu);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSalleMuscu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalleMuscu> updateSalleMuscu(@PathVariable Long id, @RequestBody SalleMuscu salleMuscu) {
        if (!salleMuscuService.getSalleMuscuById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        salleMuscu.setId(id);
        SalleMuscu updatedSalleMuscu = salleMuscuService.saveSalleMuscu(salleMuscu);
        return ResponseEntity.ok(updatedSalleMuscu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalleMuscu(@PathVariable Long id) {
        if (!salleMuscuService.getSalleMuscuById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        salleMuscuService.deleteSalleMuscu(id);
        return ResponseEntity.noContent().build();
    }
}

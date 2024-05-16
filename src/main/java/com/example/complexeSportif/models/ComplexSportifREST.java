package com.example.complexeSportif.models;

import com.example.complexeSportif.entities.ComplexeSportif;
import com.example.complexeSportif.services.ComplexeSportifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/complexe-sportif")
public class ComplexSportifREST {
    @Autowired
    private ComplexeSportifService complexeSportifService;

    @GetMapping
    public ResponseEntity<List<ComplexeSportif>> getAllComplexeSportifs() {
        List<ComplexeSportif> complexesportifs = complexeSportifService.getAllComplexeSportifs();
        return ResponseEntity.ok(complexesportifs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplexeSportif> getComplexeSportifById(@PathVariable Long id) {
        Optional<ComplexeSportif> complexeSportif = complexeSportifService.getComplexeSportifById(id);
        return complexeSportif.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ComplexeSportif> createComplexeSportif(@RequestBody ComplexeSportif complexeSportif) {
        ComplexeSportif savedComplexeSportif = complexeSportifService.saveComplexeSportif(complexeSportif);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComplexeSportif);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComplexeSportif> updateComplexeSportif(@PathVariable Long id, @RequestBody ComplexeSportif complexeSportif) {
        if (!complexeSportifService.getComplexeSportifById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        complexeSportif.setId(id);
        ComplexeSportif updatedComplexeSportif = complexeSportifService.saveComplexeSportif(complexeSportif);
        return ResponseEntity.ok(updatedComplexeSportif);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplexeSportif(@PathVariable Long id) {
        if (!complexeSportifService.getComplexeSportifById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        complexeSportifService.deleteComplexeSportif(id);
        return ResponseEntity.noContent().build();
    }
}

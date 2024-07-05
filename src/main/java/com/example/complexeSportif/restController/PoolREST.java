package com.example.complexeSportif.restController;

import com.example.complexeSportif.entities.Pool;
import com.example.complexeSportif.services.PoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pool")
@RequiredArgsConstructor
public class PoolREST {

    private final PoolService poolService;

    @GetMapping("/all")
    public ResponseEntity<List<Pool>> getAllPools() {
        List<Pool> pools = poolService.getAllPool();
        return ResponseEntity.ok(pools);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Pool> getPoolById(@PathVariable Long id) {
        Optional<Pool> pool = poolService.getPoolById(id);
        return pool.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Pool> createPool(@RequestBody Pool pool) {
        Pool savedPool = poolService.savePool(pool);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPool);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Pool> updatePool(@PathVariable Long id, @RequestBody Pool pool) {
        if (!poolService.getPoolById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pool.setId(id);
        Pool updatedPool = poolService.savePool(pool);
        return ResponseEntity.ok(updatedPool);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Void> deletePool(@PathVariable Long id) {
        if (!poolService.getPoolById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        poolService.deletePool(id);
        return ResponseEntity.noContent().build();
    }
}

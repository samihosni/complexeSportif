package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.Pool;

import java.util.List;
import java.util.Optional;

public interface PoolService {
    List<Pool> getAllPool();

    Optional<Pool> getPoolById(Long id);

    Pool savePool(Pool pool);

    void deletePool(Long id);
}

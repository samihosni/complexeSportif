package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.Courses;
import com.example.complexeSportif.entities.Pool;
import com.example.complexeSportif.repositories.CoursesRepo;
import com.example.complexeSportif.repositories.PoolRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PoolServiceImp implements PoolService {
    @Autowired
    private PoolRepo poolRepo;
    @Override
    public List<Pool> getAllPool() {
        return poolRepo.findAll();
    }
    @Override

    public Optional<Pool> getPoolById(Long id) {
        return poolRepo.findById(id);
    }
    @Override

    public Pool savePool(Pool pool) {
        return poolRepo.save(pool);
    }
    @Override

    public void deletePool(Long id) {
        poolRepo.deleteById(id);
    }
}

package com.example.complexeSportif.repositories;

import com.example.complexeSportif.entities.TerrainsFoot;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class TerrainsFootImp implements TerrainsFootRepo{
    @Override
    public void flush() {

    }

    @Override
    public <S extends TerrainsFoot> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TerrainsFoot> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<TerrainsFoot> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TerrainsFoot getOne(Long aLong) {
        return null;
    }

    @Override
    public TerrainsFoot getById(Long aLong) {
        return null;
    }

    @Override
    public TerrainsFoot getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends TerrainsFoot> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TerrainsFoot> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends TerrainsFoot> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends TerrainsFoot> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TerrainsFoot> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TerrainsFoot> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends TerrainsFoot, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends TerrainsFoot> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TerrainsFoot> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<TerrainsFoot> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<TerrainsFoot> findAll() {
        return List.of();
    }

    @Override
    public List<TerrainsFoot> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(TerrainsFoot entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends TerrainsFoot> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<TerrainsFoot> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<TerrainsFoot> findAll(Pageable pageable) {
        return null;
    }
}

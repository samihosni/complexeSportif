package com.example.complexeSportif.repositories;

import com.example.complexeSportif.entities.TerrainsPadel;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class TerrainsPadelImp implements TerrainsPadelRepo{
    @Override
    public void flush() {

    }

    @Override
    public <S extends TerrainsPadel> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TerrainsPadel> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<TerrainsPadel> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TerrainsPadel getOne(Long aLong) {
        return null;
    }

    @Override
    public TerrainsPadel getById(Long aLong) {
        return null;
    }

    @Override
    public TerrainsPadel getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends TerrainsPadel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TerrainsPadel> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends TerrainsPadel> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends TerrainsPadel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TerrainsPadel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TerrainsPadel> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends TerrainsPadel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends TerrainsPadel> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TerrainsPadel> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<TerrainsPadel> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<TerrainsPadel> findAll() {
        return List.of();
    }

    @Override
    public List<TerrainsPadel> findAllById(Iterable<Long> longs) {
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
    public void delete(TerrainsPadel entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends TerrainsPadel> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<TerrainsPadel> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<TerrainsPadel> findAll(Pageable pageable) {
        return null;
    }
}

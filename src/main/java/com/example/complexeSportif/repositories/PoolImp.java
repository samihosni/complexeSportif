package com.example.complexeSportif.repositories;

import com.example.complexeSportif.entities.Pool;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class PoolImp implements PoolRepo{
    @Override
    public void flush() {

    }

    @Override
    public <S extends Pool> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Pool> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Pool> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Pool getOne(Long aLong) {
        return null;
    }

    @Override
    public Pool getById(Long aLong) {
        return null;
    }

    @Override
    public Pool getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Pool> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Pool> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Pool> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Pool> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Pool> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Pool> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Pool, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Pool> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Pool> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Pool> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Pool> findAll() {
        return List.of();
    }

    @Override
    public List<Pool> findAllById(Iterable<Long> longs) {
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
    public void delete(Pool entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Pool> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Pool> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Pool> findAll(Pageable pageable) {
        return null;
    }
}

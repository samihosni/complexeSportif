package com.example.complexeSportif.repositories;

import com.example.complexeSportif.entities.SalleMuscu;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SalleMuscuImp implements SalleMuscuRepo{
    @Override
    public void flush() {

    }

    @Override
    public <S extends SalleMuscu> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends SalleMuscu> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<SalleMuscu> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SalleMuscu getOne(Long aLong) {
        return null;
    }

    @Override
    public SalleMuscu getById(Long aLong) {
        return null;
    }

    @Override
    public SalleMuscu getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends SalleMuscu> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SalleMuscu> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends SalleMuscu> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends SalleMuscu> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SalleMuscu> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SalleMuscu> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends SalleMuscu, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends SalleMuscu> S save(S entity) {
        return null;
    }

    @Override
    public <S extends SalleMuscu> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<SalleMuscu> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<SalleMuscu> findAll() {
        return List.of();
    }

    @Override
    public List<SalleMuscu> findAllById(Iterable<Long> longs) {
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
    public void delete(SalleMuscu entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends SalleMuscu> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<SalleMuscu> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<SalleMuscu> findAll(Pageable pageable) {
        return null;
    }
}

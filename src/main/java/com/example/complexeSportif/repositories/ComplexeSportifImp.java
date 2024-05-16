package com.example.complexeSportif.repositories;

import com.example.complexeSportif.entities.ComplexeSportif;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ComplexeSportifImp implements ComplexeSportifRepo{
    @Override
    public void flush() {

    }

    @Override
    public <S extends ComplexeSportif> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ComplexeSportif> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<ComplexeSportif> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ComplexeSportif getOne(Long aLong) {
        return null;
    }

    @Override
    public ComplexeSportif getById(Long aLong) {
        return null;
    }

    @Override
    public ComplexeSportif getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends ComplexeSportif> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ComplexeSportif> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends ComplexeSportif> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends ComplexeSportif> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ComplexeSportif> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ComplexeSportif> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ComplexeSportif, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends ComplexeSportif> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ComplexeSportif> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<ComplexeSportif> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<ComplexeSportif> findAll() {
        return List.of();
    }

    @Override
    public List<ComplexeSportif> findAllById(Iterable<Long> longs) {
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
    public void delete(ComplexeSportif entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends ComplexeSportif> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ComplexeSportif> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<ComplexeSportif> findAll(Pageable pageable) {
        return null;
    }
}

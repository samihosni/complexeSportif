package com.example.complexeSportif.repositories;

import com.example.complexeSportif.entities.Courses;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CoursesImp implements CoursesRepo{
    @Override
    public void flush() {

    }

    @Override
    public <S extends Courses> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Courses> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Courses> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Courses getOne(Long aLong) {
        return null;
    }

    @Override
    public Courses getById(Long aLong) {
        return null;
    }

    @Override
    public Courses getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Courses> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Courses> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Courses> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Courses> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Courses> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Courses> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Courses, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Courses> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Courses> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Courses> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Courses> findAll() {
        return List.of();
    }

    @Override
    public List<Courses> findAllById(Iterable<Long> longs) {
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
    public void delete(Courses entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Courses> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Courses> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Courses> findAll(Pageable pageable) {
        return null;
    }
}

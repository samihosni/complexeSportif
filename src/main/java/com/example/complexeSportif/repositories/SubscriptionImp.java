package com.example.complexeSportif.repositories;

import com.example.complexeSportif.entities.Subscriptions;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SubscriptionImp implements SubscriptionRepo{
    @Override
    public void flush() {

    }

    @Override
    public <S extends Subscriptions> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Subscriptions> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Subscriptions> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Subscriptions getOne(Long aLong) {
        return null;
    }

    @Override
    public Subscriptions getById(Long aLong) {
        return null;
    }

    @Override
    public Subscriptions getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Subscriptions> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Subscriptions> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Subscriptions> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Subscriptions> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Subscriptions> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Subscriptions> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Subscriptions, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Subscriptions> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Subscriptions> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Subscriptions> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Subscriptions> findAll() {
        return List.of();
    }

    @Override
    public List<Subscriptions> findAllById(Iterable<Long> longs) {
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
    public void delete(Subscriptions entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Subscriptions> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Subscriptions> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Subscriptions> findAll(Pageable pageable) {
        return null;
    }
}

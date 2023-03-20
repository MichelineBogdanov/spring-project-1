package com.javarush.repository;

import com.javarush.entity.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public interface Dao extends JpaRepository<Task, Integer> {

    @Override
    void flush();

    @Override
    <S extends Task> S saveAndFlush(S entity);

    @Override
    <S extends Task> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Task> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);

    @Override
    void deleteAllInBatch();

    @Override
    Task getOne(Integer integer);

    @Override
    Task getById(Integer integer);

    @Override
    Task getReferenceById(Integer integer);

    @Override
    <S extends Task> List<S> findAll(Example<S> example);

    @Override
    <S extends Task> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Task> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Task> findAll();

    @Override
    List<Task> findAllById(Iterable<Integer> integers);

    @Override
    <S extends Task> S save(S entity);

    @Override
    Optional<Task> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Task entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends Task> entities);

    @Override
    void deleteAll();

    @Override
    List<Task> findAll(Sort sort);

    @Override
    Page<Task> findAll(Pageable pageable);

    @Override
    <S extends Task> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Task> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Task> long count(Example<S> example);

    @Override
    <S extends Task> boolean exists(Example<S> example);

    @Override
    <S extends Task, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}

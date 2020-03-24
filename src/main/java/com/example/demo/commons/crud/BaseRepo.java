package com.example.demo.commons.crud;

import com.example.demo.commons.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public interface BaseRepo<T extends BaseEntity<ID>, ID extends Serializable> {

    <E extends T> E create(E entity);

    Optional<T> getById(ID id);

    List<T> getAll();

    <S> Optional<T> updateById(ID id, S source, BiFunction<S, T, T> mapper);

    void delById(ID id);
}

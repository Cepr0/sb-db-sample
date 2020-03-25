package com.example.demo.commons.impl.jpa;

import com.example.demo.commons.crud.BaseRepo;
import com.example.demo.commons.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

@Transactional
@NoRepositoryBean
public interface BaseRepoImpl<T extends BaseEntity<ID>, ID extends Serializable> extends BaseRepo<T, ID>, JpaRepository<T, ID> {
    @Override
    default <E extends T> E create(E entity) {
        return save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    default Optional<T> getById(ID id) {
        return findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    default List<T> getAll() {
        return findAll();
    }

    @Override
    default <S> Optional<T> updateById(ID id, @NonNull S source, @NonNull BiFunction<S, T, T> mapper) {
        return getById(id).map(target -> mapper.apply(source, target));
    }

    @Override
    default void delById(ID id) {
        deleteById(id);
    }

    @Override
    default T getReference(ID id) {
        return getOne(id);
    }
}

package com.example.demo.commons.crud;

import com.example.demo.commons.dto.BaseRequest;
import com.example.demo.commons.dto.BaseResponse;
import com.example.demo.commons.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable, Q extends BaseRequest, S extends BaseResponse<ID>> {

    S create(Q request);

    <E extends T> E create(E entity);

    Optional<S> getById(ID id);

    Optional<T> getEntityById(ID id);

    List<S> getAll();

    List<T> getAllEntities();

    Optional<S> update(ID id, Q source);

    Optional<T> update(ID id, T source);

    void delById(ID id);
}

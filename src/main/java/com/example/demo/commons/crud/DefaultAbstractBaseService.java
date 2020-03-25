package com.example.demo.commons.crud;

import com.example.demo.commons.dto.BaseRequest;
import com.example.demo.commons.dto.BaseResponse;
import com.example.demo.commons.model.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
public abstract class DefaultAbstractBaseService<
        T extends BaseEntity<ID>,
        ID extends Serializable,
        Q extends BaseRequest,
        S extends BaseResponse<ID>
    > implements BaseService<T, ID, Q, S> {

    protected final BaseRepo<T, ID> repo;
    protected final BaseMapper<T, ID, Q, S> mapper;

    protected DefaultAbstractBaseService(BaseRepo<T, ID> repo, BaseMapper<T, ID, Q, S> mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public S create(Q request) {
        T entity = mapper.toEntity(request);
        return mapper.toResponse(repo.create(entity));
    }

    @Override
    public <E extends T> E create(E entity) {
        return repo.create(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<S> getById(ID id) {
        return repo.getById(id).map(mapper::toResponse);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<T> getEntityById(ID id) {
        return repo.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<S> getAll() {
        return repo.getAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> getAllEntities() {
        return repo.getAll();
    }

    @Override
    public Optional<S> update(ID id, Q source) {
        return repo.updateById(id, source, mapper::update).map(mapper::toResponse);
    }

    @Override
    public Optional<T> update(ID id, T source) {
        return repo.updateById(id, source, mapper::update);
    }

    @Override
    public void delById(ID id) {
        repo.delById(id);
    }
}

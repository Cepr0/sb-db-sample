package com.example.demo.common_impl.api;

import com.example.demo.commons.crud.BaseService;
import com.example.demo.commons.dto.BaseRequest;
import com.example.demo.commons.dto.BaseResponse;
import com.example.demo.commons.model.BaseEntity;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public abstract class SyncAbstractBaseController<T extends BaseEntity<ID>, ID extends Serializable, Q extends BaseRequest, S extends BaseResponse<ID>> {

    protected final BaseService<T, ID, Q, S> service;

    protected SyncAbstractBaseController(BaseService<T, ID, Q, S> service) {
        this.service = service;
    }

    public S create(Q request) {
        return service.create(request);
    }

    public ResponseEntity<S> getById(ID id) {
        return ResponseEntity.of(service.getById(id));
    }

    public List<S> getAll() {
        return service.getAll();
    }

    public ResponseEntity<S> update(ID id, Q request) {
        return ResponseEntity.of(service.update(id, request));
    }

    public void delete(ID id) {
        service.delById(id);
    }
}

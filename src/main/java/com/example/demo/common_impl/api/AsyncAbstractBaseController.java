package com.example.demo.common_impl.api;

import com.example.demo.commons.crud.BaseService;
import com.example.demo.commons.dto.BaseRequest;
import com.example.demo.commons.dto.BaseResponse;
import com.example.demo.commons.model.BaseEntity;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public abstract class AsyncAbstractBaseController<T extends BaseEntity<ID>, ID extends Serializable, Q extends BaseRequest, S extends BaseResponse<ID>> {

    protected final BaseService<T, ID, Q, S> service;
    protected final Executor taskExecutor;

    protected AsyncAbstractBaseController(BaseService<T, ID, Q, S> service, Executor taskExecutor) {
        this.service = service;
        this.taskExecutor = taskExecutor;
    }

    public CompletableFuture<S> create(Q request) {
        return supplyAsync(() -> service.create(request), taskExecutor);
    }

    public CompletableFuture<ResponseEntity<S>> getById(ID id) {
        return supplyAsync(() -> service.getById(id)).thenApply(ResponseEntity::of);
    }

    public CompletableFuture<List<S>> getAll() {
        return supplyAsync(service::getAll);
    }

    public CompletableFuture<ResponseEntity<S>> update(ID id, Q request) {
        return supplyAsync(() -> service.update(id, request), taskExecutor)
                .thenApply(ResponseEntity::of);
    }

    public CompletableFuture<Void> delete(ID id) {
        return runAsync(() -> service.delById(id), taskExecutor);
    }
}

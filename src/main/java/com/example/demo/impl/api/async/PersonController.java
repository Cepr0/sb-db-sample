package com.example.demo.impl.api.async;

import com.example.demo.app.dto.CarResponse;
import com.example.demo.app.dto.PersonRequest;
import com.example.demo.app.dto.PersonResponse;
import com.example.demo.app.model.Person;
import com.example.demo.app.service.PersonService;
import com.example.demo.common_impl.api.AsyncAbstractBaseController;
import com.example.demo.commons.dto.OnCreate;
import com.example.demo.commons.dto.OnUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping("people")
public class PersonController extends AsyncAbstractBaseController<Person, Integer, PersonRequest, PersonResponse> {

    protected PersonController(PersonService service, Executor taskExecutor) {
        super(service, taskExecutor);
    }

    @Override
    @PostMapping
    public CompletableFuture<PersonResponse> create(@RequestBody @Validated(OnCreate.class) PersonRequest request) {
        return super.create(request);
    }

    @Override
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<PersonResponse>> getById(@PathVariable Integer id) {
        return super.getById(id);
    }

    @Override
    @GetMapping
    public CompletableFuture<List<PersonResponse>> getAll() {
        return super.getAll();
    }

    @Override
    @PatchMapping("/{id}")
    public CompletableFuture<ResponseEntity<PersonResponse>> update(@PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) PersonRequest request) {
        return super.update(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public CompletableFuture<Void> delete(@PathVariable Integer id) {
         return super.delete(id);
    }

    @GetMapping("/{personId}/cars")
    public CompletableFuture<List<CarResponse>> getCarsByPerson(@PathVariable Integer personId) {
        return supplyAsync(() -> ((PersonService) service).getCarsByPerson(personId));
    }
}

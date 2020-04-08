package com.example.demo.impl.api.sync;

import com.example.demo.app.dto.CarResponse;
import com.example.demo.app.dto.PersonRequest;
import com.example.demo.app.dto.PersonResponse;
import com.example.demo.app.model.Person;
import com.example.demo.app.service.PersonService;
import com.example.demo.common_impl.api.SyncAbstractBaseController;
import com.example.demo.commons.dto.OnCreate;
import com.example.demo.commons.dto.OnUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("people")
public class PersonController extends SyncAbstractBaseController<Person, Integer, PersonRequest, PersonResponse> {

    protected PersonController(PersonService service) {
        super(service);
    }

    @Override
    @PostMapping
    public PersonResponse create(@RequestBody @Validated(OnCreate.class) PersonRequest request) {
        return super.create(request);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getById(@PathVariable Integer id) {
        return super.getById(id);
    }

    @Override
    @GetMapping
    public List<PersonResponse> getAll() {
        return super.getAll();
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<PersonResponse> update(@PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) PersonRequest request) {
        return super.update(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
         super.delete(id);
    }

    @GetMapping("/{personId}/cars")
    public List<CarResponse> getCarsByPerson(@PathVariable Integer personId) {
        return ((PersonService) service).getCarsByPerson(personId);
    }
}

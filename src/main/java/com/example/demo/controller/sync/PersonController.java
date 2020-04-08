package com.example.demo.controller.sync;

import com.example.demo.commons.crud.SyncAbstractBaseController;
import com.example.demo.commons.dto.OnCreate;
import com.example.demo.commons.dto.OnUpdate;
import com.example.demo.dto.CarResponse;
import com.example.demo.dto.PersonRequest;
import com.example.demo.dto.PersonResponse;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Profile("!async")
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

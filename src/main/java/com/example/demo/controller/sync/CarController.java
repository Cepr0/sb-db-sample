package com.example.demo.controller.sync;

import com.example.demo.commons.crud.SyncAbstractBaseController;
import com.example.demo.commons.dto.OnCreate;
import com.example.demo.commons.dto.OnUpdate;
import com.example.demo.dto.CarRequest;
import com.example.demo.dto.CarResponse;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Profile("!async")
@RestController
@RequestMapping("cars")
public class CarController extends SyncAbstractBaseController<Car, Integer, CarRequest, CarResponse> {

    protected CarController(CarService service) {
        super(service);
    }

    @Override
    @PostMapping
    public CarResponse create(@RequestBody @Validated(OnCreate.class) CarRequest request) {
        return super.create(request);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getById(@PathVariable Integer id) {
        return super.getById(id);
    }

    @Override
    @GetMapping
    public List<CarResponse> getAll() {
        return super.getAll();
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<CarResponse> update(@PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) CarRequest request) {
        return super.update(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
         super.delete(id);
    }
}

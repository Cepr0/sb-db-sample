package com.example.demo.app.repo;

import com.example.demo.app.model.Car;
import com.example.demo.commons.crud.BaseRepo;

import java.util.List;

public interface CarRepo extends BaseRepo<Car, Integer> {
    List<Car> getAllByPersonId(Integer personId);
}

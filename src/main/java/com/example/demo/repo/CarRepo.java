package com.example.demo.repo;

import com.example.demo.commons.crud.BaseRepo;
import com.example.demo.model.Car;

import java.util.List;

public interface CarRepo extends BaseRepo<Car, Integer> {
    List<Car> getAllByPersonId(Integer personId);
}

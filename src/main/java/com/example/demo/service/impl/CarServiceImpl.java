package com.example.demo.service.impl;

import com.example.demo.commons.crud.DefaultAbstractBaseService;
import com.example.demo.dto.CarRequest;
import com.example.demo.dto.CarResponse;
import com.example.demo.mapper.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.repo.CarRepo;
import com.example.demo.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends DefaultAbstractBaseService<Car, Integer, CarRequest, CarResponse> implements CarService {
    protected CarServiceImpl(CarRepo repo, CarMapper mapper) {
        super(repo, mapper);
    }
}

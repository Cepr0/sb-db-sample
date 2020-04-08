package com.example.demo.app.service.impl;

import com.example.demo.app.dto.CarRequest;
import com.example.demo.app.dto.CarResponse;
import com.example.demo.app.mapper.CarMapper;
import com.example.demo.app.model.Car;
import com.example.demo.app.repo.CarRepo;
import com.example.demo.app.service.CarService;
import com.example.demo.commons.crud.DefaultAbstractBaseService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends DefaultAbstractBaseService<Car, Integer, CarRequest, CarResponse> implements CarService {
    protected CarServiceImpl(CarRepo repo, CarMapper mapper) {
        super(repo, mapper);
    }
}

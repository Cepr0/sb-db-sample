package com.example.demo.service;

import com.example.demo.commons.crud.BaseService;
import com.example.demo.dto.CarRequest;
import com.example.demo.dto.CarResponse;
import com.example.demo.model.Car;

public interface CarService extends BaseService<Car, Integer, CarRequest, CarResponse> {
}

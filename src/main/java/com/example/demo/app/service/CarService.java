package com.example.demo.app.service;

import com.example.demo.app.dto.CarRequest;
import com.example.demo.app.dto.CarResponse;
import com.example.demo.app.model.Car;
import com.example.demo.commons.crud.BaseService;

public interface CarService extends BaseService<Car, Integer, CarRequest, CarResponse> {
}

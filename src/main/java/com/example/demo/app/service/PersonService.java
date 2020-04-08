package com.example.demo.app.service;

import com.example.demo.app.dto.CarResponse;
import com.example.demo.app.dto.PersonRequest;
import com.example.demo.app.dto.PersonResponse;
import com.example.demo.app.model.Person;
import com.example.demo.commons.crud.BaseService;

import java.util.List;

public interface PersonService extends BaseService<Person, Integer, PersonRequest, PersonResponse> {
    List<CarResponse> getCarsByPerson(Integer personId);
}

package com.example.demo.service;

import com.example.demo.commons.crud.BaseService;
import com.example.demo.dto.CarResponse;
import com.example.demo.dto.PersonRequest;
import com.example.demo.dto.PersonResponse;
import com.example.demo.model.Person;

import java.util.List;

public interface PersonService extends BaseService<Person, Integer, PersonRequest, PersonResponse> {
    List<CarResponse> getCarsByPerson(Integer personId);
}

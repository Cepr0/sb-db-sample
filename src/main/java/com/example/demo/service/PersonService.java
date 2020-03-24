package com.example.demo.service;

import com.example.demo.commons.crud.BaseService;
import com.example.demo.dto.PersonRequest;
import com.example.demo.dto.PersonResponse;
import com.example.demo.model.Person;

public interface PersonService extends BaseService<Person, Integer, PersonRequest, PersonResponse> {
}

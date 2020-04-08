package com.example.demo.app.service.impl;

import com.example.demo.app.dto.CarResponse;
import com.example.demo.app.dto.PersonRequest;
import com.example.demo.app.dto.PersonResponse;
import com.example.demo.app.mapper.CarMapper;
import com.example.demo.app.mapper.PersonMapper;
import com.example.demo.app.model.Person;
import com.example.demo.app.repo.CarRepo;
import com.example.demo.app.repo.PersonRepo;
import com.example.demo.app.service.PersonService;
import com.example.demo.commons.crud.DefaultAbstractBaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl extends DefaultAbstractBaseService<Person, Integer, PersonRequest, PersonResponse> implements PersonService {

    private final CarRepo carRepo;
    private final CarMapper carMapper;

    protected PersonServiceImpl(PersonRepo repo, PersonMapper mapper, CarRepo carRepo, CarMapper carMapper) {
        super(repo, mapper);
        this.carRepo = carRepo;
        this.carMapper = carMapper;
    }

    @Override
    public List<CarResponse> getCarsByPerson(Integer personId) {
        return carRepo.getAllByPersonId(personId).stream().map(carMapper::toResponse).collect(Collectors.toList());
    }
}

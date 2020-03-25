package com.example.demo.service.impl;

import com.example.demo.commons.crud.DefaultAbstractBaseService;
import com.example.demo.dto.CarResponse;
import com.example.demo.dto.PersonRequest;
import com.example.demo.dto.PersonResponse;
import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.repo.CarRepo;
import com.example.demo.repo.PersonRepo;
import com.example.demo.service.PersonService;
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

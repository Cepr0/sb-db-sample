package com.example.demo.service.impl;

import com.example.demo.commons.crud.DefaultAbstractBaseService;
import com.example.demo.dto.PersonRequest;
import com.example.demo.dto.PersonResponse;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends DefaultAbstractBaseService<Person, Integer, PersonRequest, PersonResponse> implements PersonService {
    protected PersonServiceImpl(PersonRepo repo, PersonMapper mapper) {
        super(repo, mapper);
    }
}

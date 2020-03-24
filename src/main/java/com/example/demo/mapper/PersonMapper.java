package com.example.demo.mapper;

import com.example.demo.commons.crud.BaseMapper;
import com.example.demo.dto.PersonRequest;
import com.example.demo.dto.PersonResponse;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = BaseMapper.class)
public abstract class PersonMapper implements BaseMapper<Person, Integer, PersonRequest, PersonResponse> {
    @AfterMapping
    void setAddress(@MappingTarget Person person, PersonRequest request) {
        if (person != null && request != null) {
            Address address = new Address(request.getCity(), request.getStreet(), request.getNumber());
            person.setAddress(address);
        }
    }
}

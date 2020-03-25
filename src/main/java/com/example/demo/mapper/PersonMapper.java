package com.example.demo.mapper;

import com.example.demo.commons.crud.BaseMapper;
import com.example.demo.dto.PersonRequest;
import com.example.demo.dto.PersonResponse;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static java.util.Optional.ofNullable;

@Mapper(config = BaseMapper.class)
public abstract class PersonMapper implements BaseMapper<Person, Integer, PersonRequest, PersonResponse> {
    @AfterMapping
    void setAddress(PersonRequest request, @MappingTarget Person person) {
        if (person != null && request != null) {
            Address address = person.getAddress();
            String city = ofNullable(request.getCity()).orElse(address.getCity());
            String street = ofNullable(request.getStreet()).orElse(address.getStreet());
            String number = ofNullable(request.getNumber()).orElse(address.getNumber());
            person.setAddress(new Address(city, street, number));
        }
    }
}

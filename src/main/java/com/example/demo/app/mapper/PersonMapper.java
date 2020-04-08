package com.example.demo.app.mapper;

import com.example.demo.app.dto.PersonRequest;
import com.example.demo.app.dto.PersonResponse;
import com.example.demo.app.model.Address;
import com.example.demo.app.model.Person;
import com.example.demo.commons.crud.BaseMapper;
import lombok.NonNull;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static java.util.Optional.ofNullable;

@Mapper(config = BaseMapper.class)
public abstract class PersonMapper implements BaseMapper<Person, Integer, PersonRequest, PersonResponse> {
    @AfterMapping
    void setAddress(@NonNull PersonRequest request, @MappingTarget @NonNull Person person) {
        Address address = person.getAddress();
        String city = ofNullable(request.getCity()).orElse(address.getCity());
        String street = ofNullable(request.getStreet()).orElse(address.getStreet());
        String number = ofNullable(request.getNumber()).orElse(address.getNumber());
        person.setAddress(new Address(city, street, number));
    }
}

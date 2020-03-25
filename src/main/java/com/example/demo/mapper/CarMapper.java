package com.example.demo.mapper;

import com.example.demo.commons.crud.BaseMapper;
import com.example.demo.dto.CarRequest;
import com.example.demo.dto.CarResponse;
import com.example.demo.model.Car;
import com.example.demo.repo.PersonRepo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(config = BaseMapper.class, uses = PersonMapper.class)
public abstract class CarMapper implements BaseMapper<Car, Integer, CarRequest, CarResponse> {

    @Autowired private PersonRepo personRepo;

    @Mapping(target = "person", ignore = true)
    @Override
    public abstract Car toEntity(CarRequest request);

    @Mapping(target = "person", ignore = true)
    @Override
    public abstract Car update(CarRequest request, @MappingTarget Car target);

    @AfterMapping
    public void updatePerson(CarRequest request, @MappingTarget Car car) {
        Integer personId = request.getPerson();
        if (personId != null) {
            car.setPerson(personRepo.getReference(personId));
        }
    }
}

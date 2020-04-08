package com.example.demo.app.mapper;

import com.example.demo.app.dto.CarRequest;
import com.example.demo.app.dto.CarResponse;
import com.example.demo.app.model.Car;
import com.example.demo.app.repo.PersonRepo;
import com.example.demo.commons.crud.BaseMapper;
import lombok.NonNull;
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
    public void updatePerson(@NonNull CarRequest request, @MappingTarget @NonNull Car car) {
        Integer personId = request.getPerson();
        if (personId != null) {
            car.setPerson(personRepo.getReference(personId));
        }
    }
}

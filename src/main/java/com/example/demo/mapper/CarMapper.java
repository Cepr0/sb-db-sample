package com.example.demo.mapper;

import com.example.demo.commons.crud.BaseMapper;
import com.example.demo.dto.CarRequest;
import com.example.demo.dto.CarResponse;
import com.example.demo.impl.jpa.PersonRepoImpl;
import com.example.demo.model.Car;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class, uses = {PersonMapper.class, PersonRepoImpl.class})
public abstract class CarMapper implements BaseMapper<Car, Integer, CarRequest, CarResponse> {
}

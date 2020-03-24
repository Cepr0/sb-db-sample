package com.example.demo.impl.jpa;

import com.example.demo.commons.impl.jpa.BaseRepoImpl;
import com.example.demo.model.Car;
import com.example.demo.repo.CarRepo;

public interface CarRepoImpl extends BaseRepoImpl<Car, Integer>, CarRepo {
}

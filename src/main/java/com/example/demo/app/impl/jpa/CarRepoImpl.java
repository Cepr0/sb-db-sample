package com.example.demo.app.impl.jpa;

import com.example.demo.app.model.Car;
import com.example.demo.app.repo.CarRepo;
import com.example.demo.commons.impl.jpa.BaseRepoImpl;

public interface CarRepoImpl extends BaseRepoImpl<Car, Integer>, CarRepo {
}

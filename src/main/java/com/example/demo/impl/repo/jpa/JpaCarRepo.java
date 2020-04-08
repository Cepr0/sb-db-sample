package com.example.demo.impl.repo.jpa;

import com.example.demo.app.model.Car;
import com.example.demo.app.repo.CarRepo;
import com.example.demo.common_impl.repo.jpa.BaseRepoImpl;

public interface JpaCarRepo extends BaseRepoImpl<Car, Integer>, CarRepo {
}

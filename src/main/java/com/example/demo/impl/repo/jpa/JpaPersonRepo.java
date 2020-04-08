package com.example.demo.impl.repo.jpa;

import com.example.demo.app.model.Person;
import com.example.demo.app.repo.PersonRepo;
import com.example.demo.common_impl.repo.jpa.BaseRepoImpl;

public interface JpaPersonRepo extends BaseRepoImpl<Person, Integer>, PersonRepo {
}

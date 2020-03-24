package com.example.demo.impl.jpa;

import com.example.demo.commons.impl.jpa.BaseRepoImpl;
import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;

public interface PersonRepoImpl extends BaseRepoImpl<Person, Integer>, PersonRepo {
}

package com.example.demo.app.impl.jpa;

import com.example.demo.app.model.Person;
import com.example.demo.app.repo.PersonRepo;
import com.example.demo.commons.impl.jpa.BaseRepoImpl;

public interface PersonRepoImpl extends BaseRepoImpl<Person, Integer>, PersonRepo {
}

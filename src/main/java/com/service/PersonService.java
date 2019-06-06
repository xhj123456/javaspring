package com.service;

import com.pojo.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons(Integer id);
}

package com.controller;

import com.pojo.Person;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    @RequestMapping("/showPerson")
    public List<Person> showPerson(@RequestParam(value = "id",required = false)Integer id){
        return personService.getPersons(id);
    }
}

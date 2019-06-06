package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.Person;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional//事务
public class PersonServiceImpl implements PersonService {
    @Autowired
    private UserMapper userMapper;
    @Transactional(readOnly = true)
    @Override
    public List<Person> getPersons(Integer id) {
        return userMapper.getPerson(id);
    }
}

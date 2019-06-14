package com.mapper;

import com.pojo.Person;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    List<Person> getPerson(@Param("id") Integer id);
    int insertUser(User user);
    User getUserByUsername(@Param("username")String username);
    User getUserByEmail(@Param("email")String email);
    User getUserById(@Param("id") Integer id);
}

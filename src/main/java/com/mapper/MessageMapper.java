package com.mapper;

import com.pojo.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageMapper {
    List<Message> findAll();
    int addMessage(Message message);
    int count();
}
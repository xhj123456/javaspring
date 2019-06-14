package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class Message {
    private int id;
    private int uid;
    private String message;
    private User user;
    private String date;
}

package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Document {
    private int id;
    private String title;
    private String description;
    private String content;
    private String date;
    private String pic;
    private int uid;
    private int category_id;
    private User user;
    private Category category;
    private String job;
    private String hobby;
    private Integer age;
    private String skill;
    private String wx;
    private String phone;
    private String email;
    private Integer qq;
}

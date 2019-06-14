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
}

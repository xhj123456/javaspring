package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Photos {
    private int id;
    private String title;
    private String pic;
    private String addr;
    private String date;
    private int cid;
    private int uid;
    private Category category;
    private User user;
}

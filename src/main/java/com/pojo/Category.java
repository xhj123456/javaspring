package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class Category {
    private int cid;
    private String cname;
    private String icon;
    private int pid;
    private int orderby;
    private String url;
}

package com.util;

import com.pojo.Category;
import com.pojo.Document;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * 设置数据对象的公共方法
 */
@Repository
public class SetData {
    /**
     * 设置User对象
     * @param map
     * @return
     */
    @Autowired
    User user;
    public User setUser(Map<String, String[]> map){
        user.setUsername(map.get("username")[0]);
        user.setPassword(map.get("login_password")[0]);
        user.setEmail(map.get("email")[0]);
        return user;
    }
    /**
     * 设置Document对象
     * @param map
     * @return
     */
    @Autowired
    Document document;
    public Document setDocument(Map<String,String[]> map){
        Date date = new Date();
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
        String format = sfd.format(date);
        document.setCategory_id(1);
        if (map.get("content")[0]!=null){
            document.setContent(map.get("content")[0]);
        }
        document.setDate(format);
        if (map.get("description")[0]!=null){
            document.setDescription(map.get("description")[0]);
        }
        if (map.get("file")[0]!=null){
            document.setPic(map.get("file")[0]);
        }
        document.setTitle(map.get("title")[0]);
        document.setUid(1);
        return document;
    }
    /**
     * 设置Category对象
     * @param map
     * @return
     */
    @Autowired
    Category category;
    public Category setCate(Map<String,String[]> map){
        category.setPid(Integer.valueOf(map.get("pid")[0]));
        category.setIcon(map.get("icon")[0]);
        category.setCname(map.get("cname")[0]);
        category.setOrderby(Integer.valueOf(map.get("orderby")[0]));
        return category;
    }
}

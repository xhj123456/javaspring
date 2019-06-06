package com.util;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    UserService userService;
    public User setUser(Map<String, String[]> map){
        user.setUsername(map.get("username")[0]);
        user.setPassword(map.get("login_password")[0]);
        user.setEmail(map.get("email")[0]);
        return user;
    }
}

package com.service;

import com.alibaba.fastjson.JSONObject;
import com.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {
    /**
     *注册用户
     * @return
     */
    JSONObject add(User user);
    /**
     * 登陆
     */
    Map<String,String> login(HttpServletRequest request);

    /**
     * 邮箱验证码登陆
     * @param email 邮箱地址
     * @return
     */
    Map<String,String> loginedByEmail(String email);
}

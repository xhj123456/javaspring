package com.service;

import com.alibaba.fastjson.JSONObject;
import com.pojo.User;

public interface UserService {
    /**
     *注册用户
     * @return
     */
    JSONObject add(User user);
}

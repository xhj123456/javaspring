package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
//    @Autowired
//    JSONObject jsonObject;
    @Override
    public JSONObject add(User user) {
        JSONObject jsonObject = new JSONObject();
        if (user!=null){
            if (userMapper.getUserByUsername(user.getUsername())!=null){
                jsonObject.put("code",0);
                jsonObject.put("msg","用户名已存在");
            }else if(userMapper.getUserByEmail(user.getEmail())!=null){
                jsonObject.put("code",0);
                jsonObject.put("msg","邮箱已注册");
            } else {
                int i = userMapper.insertUser(user);
                if (i>0){
                    jsonObject.put("code",200);
                    jsonObject.put("msg","注册成功");
                }else {
                    jsonObject.put("code",0);
                    jsonObject.put("msg","注册失败");
                }
            }
        }
        return jsonObject;
    }
}

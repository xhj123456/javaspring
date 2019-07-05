package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import com.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    HttpSession httpSession;
    @Autowired
    Md5 md5;
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

    @Override
    public Map<String, String> login(HttpServletRequest request) {
        Map<String, String> json = new HashMap<String, String>();
        //根据用户名获取用户信息
        User user = userMapper.getUserByUsername(request.getParameter("username"));
        if (user!=null){
//            if (user.getPassword()!=null && user.getPassword().equals(request.getParameter("pass_word"))){
            if (md5.verify(request.getParameter("pass_word"),user.getPassword())){
                httpSession.setAttribute("user",user);
                json.put("code","200");
                json.put("msg","登陆成功");
            }else{
                json.put("code","0");
                json.put("msg","密码错误");
            }
        }else {
            json.put("code","0");
            json.put("msg","用户名错误");
        }
        return json;
    }

    @Override
    public Map<String, String> loginedByEmail(String email) {
        Map<String, String> map = new HashMap<String, String>();
        User user = userMapper.getUserByEmail(email);
        if (user==null){
            map.put("code","0");
            map.put("msg","此邮箱未注册");
        }else {
            httpSession.setAttribute("user",user);
            map.put("code","200");
            map.put("msg","登陆成功");
        }
        return map;
    }
}

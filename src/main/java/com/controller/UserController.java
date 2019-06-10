package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.pojo.User;
import com.service.UserService;
import com.util.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    SetData setData;
    @Autowired
    UserService userService;
    /**
     * 注册
     */
    @RequestMapping("/addUser")
    public JSONObject addUser(HttpServletRequest request){
        User user = setData.setUser(request.getParameterMap());
        JSONObject json = userService.add(user);
        return json;
    }
    /**
     * 登陆
     */
    @RequestMapping("/loginByUser")
    public Map<String,String> loginByUser(HttpServletRequest request){
        Map<String, String> map = userService.login(request);
        return map;
    }
    @RequestMapping("/loginByEmail")
    public Map<String,String> loginByEmail(HttpServletRequest request){
        return userService.loginedByEmail(request.getParameter("email"));
    }
}

package com.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/logins")
    public JSONObject logins(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",0);

        return jsonObject;
    }
}

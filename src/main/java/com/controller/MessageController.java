package com.controller;

import com.pojo.Message;
import com.pojo.User;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@PropertySource("classpath:config/config.properties")
public class MessageController {
    @Value("${numEveryPage}")
    private String numEveryPage;
    @Autowired
    MessageService messageService;
    @Autowired
    Message message;
    @RequestMapping("/addMsg")
    public Map<String,String> addMsg(@RequestParam(value = "msg")String msg){
        message.setMessage(msg);
        return messageService.add(message);
    };
}

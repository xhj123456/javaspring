package com.controller;

import com.pojo.Message;
import com.pojo.User;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class MessageController {
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

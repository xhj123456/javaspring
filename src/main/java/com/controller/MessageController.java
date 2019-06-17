package com.controller;

import com.pojo.Message;
import com.pojo.User;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @RequestMapping("/msgList")
    public Map<String,Object> msgList(HttpServletRequest request){
        Integer curr = request.getParameter("curr")==null?1:Integer.valueOf(request.getParameter("curr"));
        Integer begin = (curr-1)*Integer.valueOf(numEveryPage);
        List<Message> list = messageService.getAllMessage(begin, Integer.valueOf(numEveryPage));
        Map<String, Object> map = new HashMap<>();
        map.put("data",list);
        return map;
    };
}

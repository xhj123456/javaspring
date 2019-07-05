package com.controller.admin;

import com.pojo.Message;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LeacotsController extends MyController {
    @Autowired
    MessageService messageService;
    @RequestMapping("/admin/leacots")
    public String leacots(HttpServletRequest request, Model model){
        Map<String, String> data = getData(request, model);
        Map<String, Object> message = getMessage(request, data);
        System.out.println(data);
        model.addAttribute("message",message);
        model.addAttribute("data",data);
        return "admin/html/leacots";
    }
    public Map<String,Object> getMessage(HttpServletRequest request,Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Map<String, Integer> map1 = getMap(request);
//        //获取文章列表
        List<Message> messages = messageService.message_list(data.get("start"),
                data.get("end"),map1.get("begin"),map1.get("num"),0);
//        //获取总条数
        int count = messageService.getCount(data.get("start"), data.get("end"),0);
        map.put("messageList",messages);
        map.put("count",count);//总条数
        map.put("map",map1);
        return map;
    }
}

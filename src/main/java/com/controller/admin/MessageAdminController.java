package com.controller.admin;

import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@RestController
public class MessageAdminController {
    @Autowired
    MessageService messageService;
    @RequestMapping("/admin/delLeacot")
    public Map<String,String> del(HttpServletRequest request){
        System.out.println(request.getParameter("ids"));
        Map<String, String> map = messageService.message_del(Integer.valueOf(request.getParameter("ids")));
        return map;
    }
    @RequestMapping("admin/delLeacotBatch")
    public Map<String,String> delBatch(@RequestParam("ids[]") Integer[] ids){
        return messageService.message_dels(ids);
    }
}

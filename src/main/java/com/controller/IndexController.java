package com.controller;

import com.service.DocumentService;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PropertySource("classpath:config/config.properties")
public class IndexController {
    @Value("${numEveryPage}")
    private String numEveryPage;
    @Autowired
    MessageService messageService;
    @Autowired
    DocumentService documentService;
    @RequestMapping("/")
    public String index(Model model){
        Integer num = Integer.valueOf(numEveryPage);
        model.addAttribute("count",documentService.count("","",""));
        model.addAttribute("num",num);
        model.addAttribute("list",documentService.document_list("","","",0,num));
        return "index";
    }
    @RequestMapping("/leacots")
    public String leacots(Model model){
        model.addAttribute("message",messageService.getAllMessage(0,Integer.valueOf(numEveryPage)));
        model.addAttribute("count",messageService.getCount());
        model.addAttribute("num",numEveryPage);
        return "leacots";
    }
    @RequestMapping("/yzm")
    public String yzm(){
        return "yzm";
    }
    @RequestMapping("/email_yzm")
    public String email_yzm(){
        return "email_yzm";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/registered")
    public String registered(){
        return "registered";
    }
}

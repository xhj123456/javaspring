package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/admin")
    public String index(){
        return "admin/index";
    }
    @RequestMapping("/admin/sucai")
    public String sucai(){
        return "admin/sucai";
    }
    @RequestMapping("/admin/welcome")
    public String welcome(){
        return "admin/html/welcome";
    }
    @RequestMapping("/admin/document")
    public String document(){
        return "admin/html/document";
    }
    @RequestMapping("/admin/document-add")
    public String document_add(){
        return "admin/html/document-add";
    }
}

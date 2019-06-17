package com.controller.admin;

import com.pojo.Document;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@PropertySource("classpath:config/config.properties")
public class AdminController {
    @Value("${numEveryPage}")
    private String numEveryPage;
    @Autowired
    DocumentService documentService;
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
    public String document(HttpServletRequest request, Model model){
        Integer page = 1;
        if (request.getParameter("page")!=null){
            page = Integer.valueOf(request.getParameter("page"));//当前页数
        }
        int begin = (page-1)*Integer.valueOf(numEveryPage);
        String title = request.getParameter("title")==null?"":request.getParameter("title");
        String start = request.getParameter("start")==null?"":request.getParameter("start");
        String end = request.getParameter("end")==null?"":request.getParameter("end");
        //获取文章类别
        List<Document> documents = documentService.document_list(title, start, end,begin,Integer.valueOf(numEveryPage));
        //获取总条数
        int count = documentService.count(title, start, end);
        model.addAttribute("documentList",documents);
        model.addAttribute("count",count);//总条数
        model.addAttribute("current",page);//当前页数
        model.addAttribute("num",numEveryPage);//每页条数
        model.addAttribute("title",title);//每页条数
        model.addAttribute("start",start);//每页条数
        model.addAttribute("end",end);//每页条数
        return "admin/html/document";
    }
    @RequestMapping("/admin/document-add")
    public String document_add(){
        return "admin/html/document-add";
    }
}

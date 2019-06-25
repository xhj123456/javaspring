package com.controller;

import com.pojo.Document;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@PropertySource("classpath:config/config.properties")
public class ArticleController {
    @Value("${numEveryPage}")
    private String numEveryPage;
    @Autowired
    DocumentService documentService;
//    @RequestMapping("/articleList")
//    public Map<String,Object> list(HttpServletRequest request){
//        Integer curr = request.getParameter("curr")==null?1:Integer.valueOf(request.getParameter("curr"));
//        Integer begin = (curr-1)*Integer.valueOf(numEveryPage);
//        Integer num = Integer.valueOf(numEveryPage);
//        int cid = Integer.valueOf(request.getParameter("cid"));
//        List<Document> list = documentService.document_list("","","",begin,num,cid);
//        Map<String, Object> map = new HashMap<>();
//        map.put("data",list);
//        return map;
//    }
    @RequestMapping("articleList")
    public String test(HttpServletRequest request){
        Integer curr = request.getParameter("curr")==null?1:Integer.valueOf(request.getParameter("curr"));
        Integer begin = (curr-1)*Integer.valueOf(numEveryPage);
        Integer num = Integer.valueOf(numEveryPage);
        int cid = Integer.valueOf(request.getParameter("cid"));
        List<Document> list = documentService.document_list("","","",begin,num,cid);
        request.setAttribute("list",list);
        return "index::item";
    }
}

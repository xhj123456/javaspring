package com.controller.admin;

import com.pojo.Document;
import com.service.DocumentService;
import com.util.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class DocumentController {
    @Autowired
    SetData setData;
    @Autowired
    DocumentService documentService;
    @RequestMapping("/admin/add")
    public Map<String,String> add(HttpServletRequest request){
        System.out.println(request.getParameter("content"));
        Document document = setData.setDocument(request.getParameterMap());
        Map<String, String> map = documentService.document_add(document);
        return map;
    }
}

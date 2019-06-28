package com.controller.admin;

import com.mapper.DocumentMapper;
import com.pojo.Document;
import com.service.DocumentService;
import com.util.SetData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@RestController
public class DocumentController {
    @Autowired
    SetData setData;
    @Autowired
    DocumentService documentService;
    @Autowired
    DocumentMapper documentMapper;
    @RequestMapping("/admin/add")
    public Map<String,String> add(HttpServletRequest request){
        System.out.println(request.getParameter("content"));
        Document document = setData.setDocument(request.getParameterMap());
        Map<String, String> map = documentService.document_add(document);
        return map;
    }
    @RequestMapping("/admin/edit")
    public Map<String,String> edit(HttpServletRequest request){
        System.out.println(request.getParameter("content"));
        Document document = setData.setDocument(request.getParameterMap());
        Map<String, String> map = documentService.document_save(document);
        return map;
    }
    @RequestMapping("/admin/del")
    public Map<String,String> del(HttpServletRequest request){
        System.out.println(request.getParameter("ids"));
        Map<String, String> map = documentService.document_del(request.getParameter("ids"));
        return map;
    }
    @RequestMapping("admin/delBatch")
    public Map<String,String> delBatch(@RequestParam("ids[]") Integer[] ids){
        return documentService.document_dels(ids);
    }
}

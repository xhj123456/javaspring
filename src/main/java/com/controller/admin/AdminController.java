package com.controller.admin;

import com.mapper.CategoryMapper;
import com.pojo.Category;
import com.pojo.Document;
import com.service.CategoryService;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController extends MyController{
    @Autowired
    DocumentService documentService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryMapper categoryMapper;
    @RequestMapping("/admin")
    public String index(){
        return "admin/index";
    }
    @RequestMapping("/admin/sucai")
    public String sucai(Model model){
        model.addAttribute("cate", categoryService.category_list());
        return "admin/sucai";
    }
    @RequestMapping("/admin/welcome")
    public String welcome(){
        return "admin/html/welcome";
    }
    @RequestMapping("/admin/index")
    public String document(HttpServletRequest request, Model model){
        Map<String, String> data = getData(request, model);
        Map<String, Object> document = getDocument(request, data);
        model.addAttribute("document",document);
        model.addAttribute("data",data);
        return "admin/html/document";
    }
    @RequestMapping("/admin/whisper")
    public String whisper(HttpServletRequest request, Model model){
        Map<String, String> data = getData(request, model);
        Map<String, Object> document = getDocument(request, data);
        model.addAttribute("document",document);
        model.addAttribute("data",data);
        return "admin/html/document";
    }
    @RequestMapping("/admin/about")
    public String about(HttpServletRequest request, Model model){
        Map<String, String> data = getData(request, model);
        Map<String, Object> document = getDocument(request, data);
        model.addAttribute("document",document);
        model.addAttribute("data",data);
        return "admin/html/document";
    }
    @RequestMapping("/admin/document-add")
    public String document_add(Model model,@RequestParam("cid")String cid){
        System.out.println(cid);
        Category cateById = categoryMapper.getCateById(Integer.valueOf(cid));
        model.addAttribute("cid",Integer.valueOf(cid));
        model.addAttribute("pid",cateById.getPid());
        return "admin/html/document-add";
    }
    @RequestMapping("/admin/document-edit")
    public String document_edit(Model model,@RequestParam("id")String id,@RequestParam("cid")String cid){
        System.out.println(id+"1111");
        Category cateById = categoryMapper.getCateById(Integer.valueOf(cid));
        model.addAttribute("cid",Integer.valueOf(cid));
        model.addAttribute("pid",cateById.getPid());
        model.addAttribute("document",documentService.document_details(Integer.valueOf(id)));
        return "admin/html/document-edit";
    }
    @RequestMapping("/admin/category")
    public String category_list(Model model){
        model.addAttribute("cate", categoryService.category_list());
        return "admin/html/category";
    }

    public Map<String,Object> getDocument(HttpServletRequest request,Map<String,String> data){
        Map<String, Integer> map = getMap(request);
        //获取文章列表
        List<Document> documents = documentService.document_list(data.get("title"), data.get("start"),
                data.get("end"),map.get("begin"),map.get("num"),map.get("cid"));
        //获取总条数
        int count = documentService.count(data.get("title"), data.get("start"), data.get("end"),map.get("cid"));
        Map<String,Object> map1 = new HashMap<>();
//        map1 = map;
        map1.put("documentList",documents);
        map1.put("count",count);//总条数
        map1.put("map",map);
//        map.put("current",page);//当前页数
//        map.put("cid",cid);
        return map1;
    }
}

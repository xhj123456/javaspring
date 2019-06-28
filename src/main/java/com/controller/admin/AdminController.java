package com.controller.admin;

import com.pojo.Document;
import com.service.CategoryService;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController extends MyController{
    @Autowired
    DocumentService documentService;
    @Autowired
    CategoryService categoryService;
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
        Integer page = 1;
        if (request.getParameter("page")!=null){
            page = Integer.valueOf(request.getParameter("page"));//当前页数
        }
        int begin = (page-1)*Integer.valueOf(numEveryPage);
        Integer num = Integer.valueOf(numEveryPage);
        int cid = Integer.valueOf(request.getParameter("cid"));
        Map<String, String> data = getData(request, model);
        //获取文章列表
        List<Document> documents = documentService.document_list(data.get("title"), data.get("start"),
                data.get("end"),begin,num,cid);
        System.out.println(documents);
        //获取总条数
        int count = documentService.count(data.get("title"), data.get("start"), data.get("end"),cid);
        model.addAttribute("documentList",documents);
        model.addAttribute("count",count);//总条数
        model.addAttribute("current",page);//当前页数
        model.addAttribute("num",numEveryPage);//每页条数
        model.addAttribute("title",data.get("title"));//标题
        model.addAttribute("start",data.get("start"));//开始时间
        model.addAttribute("end", data.get("end"));//结束时间
        model.addAttribute("cid",cid);//分类id
        return "admin/html/document";
    }
    @RequestMapping("/admin/document-add")
    public String document_add(Model model,@RequestParam("cid")String cid){
        model.addAttribute("cid",cid);
        return "admin/html/document-add";
    }
    @RequestMapping("/admin/document-edit")
    public String document_edit(Model model,@RequestParam("id")String id,@RequestParam("cid")String cid){
        System.out.println(id+"1111");
        model.addAttribute("cid",cid);
        model.addAttribute("document",documentService.document_details(Integer.valueOf(id)));
        return "admin/html/document-edit";
    }
    @RequestMapping("/admin/category")
    public String category_list(Model model){
        model.addAttribute("cate", categoryService.category_list());
        return "admin/html/category";
    }
}

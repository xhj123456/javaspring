package com.controller.admin;

import com.pojo.Category;
import com.service.CategoryService;
import com.util.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class CategoryController {
    @Autowired
    SetData setData;
    @Autowired
    CategoryService categoryService;
    @RequestMapping("/admin/addCate")
    public Map<String,String> addCate(HttpServletRequest request){
        Category category = setData.setCate(request.getParameterMap());
        return categoryService.category_add(category);
    };
}

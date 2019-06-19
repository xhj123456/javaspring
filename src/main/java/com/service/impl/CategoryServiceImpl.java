package com.service.impl;

import com.mapper.CategoryMapper;
import com.pojo.Category;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public Map<String, String> category_add(Category category) {
        Map<String,String> map = new HashMap<>();
        int add = categoryMapper.add(category);
        if (add>0){
            map.put("code","200");
            map.put("code","增加成功");
        }else {
            map.put("code","0");
            map.put("code","增加失败");
        }
        return null;
    }

    @Override
    public Map<Object,Object> category_list() {
        Map<Object,Object> map = new HashMap<>();
        List<Category> categories = categoryMapper.cateList();
        List<Category> cate1= new ArrayList<>();
        List<Category> cate2= new ArrayList<>();
        for (Category cate:categories){
            if (cate.getPid()==0){
                cate2.add(cate);
            }else {
                cate1.add(cate);
            }
        }
        map.put("cate",cate2);
        map.put("data",cate1);
        return map;
    }
}

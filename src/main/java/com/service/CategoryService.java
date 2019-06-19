package com.service;

import com.pojo.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    /**
     * 新增分类
     * @return
     */
    Map<String,String> category_add(Category category);
    Map<Object,Object> category_list();
}

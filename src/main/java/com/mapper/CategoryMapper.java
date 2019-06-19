package com.mapper;

import com.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    int add(Category category);
    List<Category> cateList();
    Category getCateById(Integer id);
}

package com.mapper;

import com.pojo.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentMapper {
    /**
     * 新增文章
     * @param document
     * @return
     */
    int addDocument(Document document);
    /**
     * 获取文章列表
     * @param title 标题
     * @param start 开始时间
     * @param end 结束时间
     * @param begin 开始条数
     * @param num 每页条数
     * @return
     */
    List<Document> getAllDocument(String title,String start,String end,int begin,int num);
    int getCount(String title,String start,String end);
}

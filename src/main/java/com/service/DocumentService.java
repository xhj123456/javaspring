package com.service;

import com.pojo.Document;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface DocumentService {
    /**
     * 新增文章
     * @param document
     * @return
     */
    Map<String,String> document_add(Document document);

    /**
     * 获取文章列表
     * @param title 标题
     * @param start 开始时间
     * @param end 结束时间
     * @param begin 开始条数
     * @param num 每页条数
     * @param cid 分类id
     * @return
     */
    List<Document> document_list(String title,String start,String end,int begin,int num,int cid);
    int count(String title,String start,String end,int cid);
}

package com.service;

import com.pojo.Document;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface DocumentService {
    /**
     * 新增文章
     * @param document
     * @return
     */
    Map<String,String> document_add(Document document);
}

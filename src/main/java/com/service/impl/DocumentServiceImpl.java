package com.service.impl;

import com.mapper.DocumentMapper;
import com.pojo.Document;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentMapper documentMapper;
    @Override
    public Map<String, String> document_add(Document document) {
        Map<String, String> map = new HashMap<>();
        int i = documentMapper.addDocument(document);
        if (i>0){
            map.put("code","200");
            map.put("msg","添加成功");
        }else {
            map.put("code","0");
            map.put("msg","添加失败");
        }
        return map;
    }
}

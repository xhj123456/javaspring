package com.service.impl;

import com.mapper.DocumentMapper;
import com.pojo.Document;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<Document> document_list(String title, String start, String end,int begin,int num,int cid) {
        return documentMapper.getAllDocument(title,start,end,begin,num,cid);
    }

    @Override
    public int count(String title,String start,String end,int cid) {
        return documentMapper.getCount(title, start, end,cid);
    }
}

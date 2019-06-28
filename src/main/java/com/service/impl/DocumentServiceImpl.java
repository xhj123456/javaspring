package com.service.impl;

import com.mapper.DocumentMapper;
import com.pojo.Document;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentMapper documentMapper;
//    @Transactional(readOnly = true)
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

    @Override
    public Document document_details(int id) {
        return documentMapper.getDocumentById(id);
    }

    @Override
    public Document document_prev(int id) {
        return documentMapper.getPrevDocumentById(id);
    }

    @Override
    public Document document_next(int id) {
        return documentMapper.getNextDocumentById(id);
    }

    @Override
    public Map<String, String> document_save(Document document) {
        Map<String, String> map = new HashMap<>();
        int i = documentMapper.updateDocumentById(document);
        if (i>0){
            map.put("code","200");
            map.put("msg","修改成功");
        }else {
            map.put("code","0");
            map.put("msg","修改失败");
        }
        return map;
    }

    @Override
    public Map<String, String> document_del(String ids) {
        Map<String, String> map = new HashMap<>();
        int i = documentMapper.deleteDocument(ids);
        if (i>0){
            map.put("code","200");
            map.put("msg","删除成功");
        }else {
            map.put("code","0");
            map.put("msg","删除失败");
        }
        return map;
    }

    @Override
    public Map<String, String> document_dels(Integer[] ids) {
        Map<String, String> map = new HashMap<>();
        int i = documentMapper.deleteDocuments(ids);
        if (i>0){
            map.put("code","200");
            map.put("msg","删除成功");
        }else {
            map.put("code","0");
            map.put("msg","删除失败");
        }
        return map;
    }
}

package com.service.impl;

import com.mapper.PhotosMapper;
import com.pojo.Photos;
import com.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PhotosServiceImpl implements PhotosService {
    @Autowired
    PhotosMapper photosMapper;
    @Override
    public Map<String,String> addPhotos(Photos photos) {
        Map<String,String> map = new HashMap<>();
        int i = photosMapper.insertPhotos(photos);
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
    public List<Photos> photos_list(String title, String start, String end, int begin, int num, int cid) {
        return photosMapper.selectAll(title,start,end,begin,num,cid);
    }

    @Override
    public int count(String title, String start, String end, int cid) {
        return photosMapper.getCount(title,start,end,cid);
    }

    @Override
    public Photos photos_detail(Integer id) {
        return photosMapper.getPhotoById(id);
    }

    @Override
    public Map<String, String> photos_edit(Photos photos) {
        Map<String,String> map = new HashMap<>();
        int i = photosMapper.updatePhotos(photos);
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
    public Map<String, String> photos_del(Integer id) {
        Map<String,String> map = new HashMap<>();
        int i = photosMapper.delPhoto(id);
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
    public Map<String, String> photos_delBatch(Integer[] ids) {
        Map<String,String> map = new HashMap<>();
        int i = photosMapper.delPhotosBatch(ids);
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

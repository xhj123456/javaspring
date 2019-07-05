package com.controller.admin;

import com.pojo.Document;
import com.pojo.Photos;
import com.service.PhotosService;
import com.util.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class PhotosController {
    @Autowired
    SetData setData;
    @Autowired
    PhotosService photosService;
    @RequestMapping("/admin/addPhoto")
    public Map<String,String> add(HttpServletRequest request){
        Photos photos = setData.setPhotos(request.getParameterMap());
        Map<String, String> map = photosService.addPhotos(photos);
        return map;
    }
    @RequestMapping("/admin/editPhoto")
    public Map<String,String> edit(HttpServletRequest request){
        Photos photos = setData.setPhotos(request.getParameterMap());
        Map<String, String> map = photosService.photos_edit(photos);
        return map;
    }
    @RequestMapping("/admin/delPhoto")
    public Map<String,String> del(@RequestParam("ids")Integer ids){
        System.out.println(ids);
        Map<String, String> map = photosService.photos_del(ids);
        return map;
    }
    @RequestMapping("/admin/delPhotosBatch")
    public Map<String,String> delBatch(@RequestParam("ids[]")Integer[] ids){
        System.out.println(ids);
        Map<String, String> map = photosService.photos_delBatch(ids);
        return map;
    }
}

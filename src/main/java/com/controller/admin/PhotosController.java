package com.controller.admin;

import com.pojo.Document;
import com.pojo.Photos;
import com.service.PhotosService;
import com.util.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
        System.out.println(request.getParameter("content"));
        Photos photos = setData.setPhotos(request.getParameterMap());
        Map<String, String> map = photosService.addPhotos(photos);
        return map;
    }
}

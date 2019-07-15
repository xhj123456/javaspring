package com.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FileController {
    /**
     * 单图片上传
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/admin/upload")
    public Map<String,Object> upload(@RequestParam("file") MultipartFile file) throws IOException {
//        for (MultipartFile file : files) {
            file.transferTo(new File("E:\\upload\\" + file.getOriginalFilename()));
//        }
        Map<String,Object> map=new HashMap<>();
        Map<String,String> map1=new HashMap<>();
        map1.put("src","/image/"+file.getOriginalFilename());
        map1.put("title",file.getOriginalFilename());
        map.put("code","0");
        map.put("msg","上传成功");
        map.put("data",map1);
        return map;
    }
    @RequestMapping("/admin/uploads")
    public Map<String,Object> uploads(@RequestParam("file") MultipartFile[] files) throws IOException {
        List<Object> list = new ArrayList<>();
        System.out.println(files.toString());
        for (MultipartFile file : files) {
            file.transferTo(new File("E:\\uploads\\" + file.getOriginalFilename()));
            Map<String,String> map1=new HashMap<>();
            map1.put("src","/image/"+file.getOriginalFilename());
            map1.put("title",file.getOriginalFilename());
            list.add("/image/"+file.getOriginalFilename());
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code","0");
        map.put("msg","上传成功");
        map.put("data",list);
        System.out.println(list.toString());
        return map;
    }
}
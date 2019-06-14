package com.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {
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
}

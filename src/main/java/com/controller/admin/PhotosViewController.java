package com.controller.admin;

import com.pojo.Photos;
import com.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class PhotosViewController extends MyController {
    @Autowired
    PhotosService photosService;
    @RequestMapping("/admin/album")
    public String photos_list(HttpServletRequest request, Model model){
        Map<String, String> data = getData(request, model);
        Integer page = 1;
        if (request.getParameter("page")!=null){
            page = Integer.valueOf(request.getParameter("page"));//当前页数
        }
        int begin = (page-1)*Integer.valueOf(numEveryPage);
        Integer num = Integer.valueOf(numEveryPage);
        Integer cid = Integer.valueOf(data.get("cid"));
        List<Photos> photos = photosService.photos_list(data.get("title"), data.get("start"),
                data.get("end"), begin, num, cid);
        int count = photosService.count(data.get("title"), data.get("start"), data.get("end"), cid);
        model.addAttribute("photosList",photos);
        model.addAttribute("count",count);//总条数
        model.addAttribute("current",page);//当前页数
        model.addAttribute("num",numEveryPage);//每页条数
        model.addAttribute("title",data.get("title"));//标题
        model.addAttribute("start",data.get("start"));//开始时间
        model.addAttribute("end", data.get("end"));//结束时间
        model.addAttribute("cid",cid);//分类id
        return "admin/html/photos";
    }
    @RequestMapping("admin/photos-add")
    public String photos_add(Model model,@RequestParam("cid")String cid){
        model.addAttribute("cid",cid);
        return "admin/html/photos-add";
    }
    @RequestMapping("admin/photos-edit")
    public String photos_edit(Model model,@RequestParam("cid")String cid,@RequestParam("id")Integer id){
        model.addAttribute("cid",cid);
        model.addAttribute("photosList",photosService.photos_detail(id));
        return "admin/html/photos-edit";
    }

}

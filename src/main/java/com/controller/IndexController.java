package com.controller;

import com.pojo.Message;
import com.pojo.Photos;
import com.service.CategoryService;
import com.service.DocumentService;
import com.service.MessageService;
import com.service.PhotosService;
import com.util.SetData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@PropertySource("classpath:config/config.properties")
public class IndexController {
    @Value("${numEveryPage}")
    private String numEveryPage;
    @Autowired
    MessageService messageService;
    @Autowired
    DocumentService documentService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    PhotosService photosService;
    @Autowired
    SetData setData;
    @RequestMapping("/index")
    public String index(Model model, @Param(value = "cid")String cid){
        int cateId = cid==null?3:Integer.valueOf(cid);//分类id
        Integer num = Integer.valueOf(numEveryPage);
        model.addAttribute("count",documentService.count("","","",cateId));
        model.addAttribute("num",num);
        model.addAttribute("list",documentService.document_list("","","",0,num,cateId));
        model.addAttribute("cate",categoryService.category_list());
        model.addAttribute("cid",1);
        model.addAttribute("contact",documentService.document_list("","","",0,1,14).get(0));
        model.addAttribute("cateId",cateId);
        return "index";
    }
    @RequestMapping("/documentDetails")
    public String documentDetails(@RequestParam("id")int id,Model model){
        model.addAttribute("detail",documentService.document_details(id));
        model.addAttribute("cate",categoryService.category_list());
        model.addAttribute("cid",1);
        model.addAttribute("contact",documentService.document_list("","","",0,1,14).get(0));
        model.addAttribute("prev",documentService.document_prev(id)==null?0:documentService.document_prev(id).getId());
        model.addAttribute("next",documentService.document_next(id)==null?0:documentService.document_next(id).getId());
        return "details";
    }
    @RequestMapping("/leacots")
    public String leacots(Model model){
        model.addAttribute("message",messageService.getAllMessage(0,Integer.valueOf(numEveryPage)));
        model.addAttribute("count",messageService.getCount());
        model.addAttribute("num",numEveryPage);
        model.addAttribute("contact",documentService.document_list("","","",0,1,14).get(0));
        model.addAttribute("cate",categoryService.category_list());
        model.addAttribute("cid",6);
        return "leacots";
    }
    @RequestMapping("/album")
    public String album(Model model) throws ParseException {
        model.addAttribute("cate",categoryService.category_list());
        List<Photos> photos = photosService.photos_list("", "", "", 0, 1, 9);
        Photos photoFirst = photos.get(0);
        System.out.println(photoFirst);
        String dateStr = "";
        if (setData.getDate().equals(photoFirst.getDate())) {
           dateStr = "今日上传";
        }else{
            Date date = new Date();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(photoFirst.getDate());
            long l = (date.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24);
            dateStr = l+"天前上传";
        }
        model.addAttribute("contact",documentService.document_list("","","",0,1,14).get(0));
        model.addAttribute("cid",7);
        model.addAttribute("date",dateStr);
        model.addAttribute("photosFirst",photoFirst);
        model.addAttribute("photosList",photosService.photos_list("","","",1,100,9));
        return "album";
    }
    @RequestMapping("/whisper")
    public String whisper(Model model){
        model.addAttribute("cate",categoryService.category_list());
        model.addAttribute("contact",documentService.document_list("","","",0,1,14).get(0));
        model.addAttribute("cid",2);
        return "whisper";
    }
    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("message",documentService.document_list("","","",0,1,12).get(0));
        model.addAttribute("skillList",documentService.document_list("","","",0,4,13));
        model.addAttribute("contact",documentService.document_list("","","",0,1,14).get(0));
        model.addAttribute("cate",categoryService.category_list());
        model.addAttribute("cid",8);
        return "about";
    }
    @RequestMapping("/yzm")
    public String yzm(){
        return "yzm";
    }
//    @RequestMapping("/footer")
//    public String footer(Model model){
//        model.addAttribute("contact",documentService.document_list("","","",0,1,14).get(0));
//        return "footer";
//    }
    @RequestMapping("/email_yzm")
    public String email_yzm(){
        return "email_yzm";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/registered")
    public String registered(){
        return "registered";
    }
    @RequestMapping("/msgList")
    public String msgList(HttpServletRequest request){
        Integer curr = request.getParameter("curr")==null?1:Integer.valueOf(request.getParameter("curr"));
        Integer begin = (curr-1)*Integer.valueOf(numEveryPage);
        List<Message> list = messageService.getAllMessage(begin, Integer.valueOf(numEveryPage));
        request.setAttribute("message",list);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("data",list);
        return "leacots::item";
    };
}

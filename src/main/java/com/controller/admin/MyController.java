package com.controller.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@PropertySource("classpath:config/config.properties")
public class MyController {
    @Value("${numEveryPage}")
    protected String numEveryPage;
    public Map<String,String> getData(HttpServletRequest request, Model model){
        Map<String,String> map = new HashMap<>();
        String title = request.getParameter("title")==null?"":request.getParameter("title");
        String start = request.getParameter("start")==null?"":request.getParameter("start");
        String end = request.getParameter("end")==null?"":request.getParameter("end");
        String cid = request.getParameter("cid")==null?"":request.getParameter("cid");
        map.put("title",title);//标题
        map.put("start",start);//开始时间
        map.put("end",end);//结束时间
        map.put("cid",cid);//分类id
        map.put("num",numEveryPage);//每页条数
        return map;
    }

    public Map<String,Integer> getMap(HttpServletRequest request){
        Map<String,Integer> map = new HashMap<>();
        Integer page = 1;
        if (request.getParameter("page")!=null){
            page = Integer.valueOf(request.getParameter("page"));//当前页数
        }
        int begin = (page-1)*Integer.valueOf(numEveryPage);
        Integer num = Integer.valueOf(numEveryPage);
        int cid = Integer.valueOf(request.getParameter("cid"));
        map.put("current",page);//当前页数
        map.put("cid",cid);
        map.put("begin",begin);
        map.put("num",num);
        return map;
    }
}

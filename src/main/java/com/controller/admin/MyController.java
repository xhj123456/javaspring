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
        map.put("title",title);
        map.put("start",start);
        map.put("end",end);
        map.put("cid",cid);
        return map;
    }
}

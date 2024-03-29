package com.service.impl;

import com.mapper.MessageMapper;
import com.pojo.Message;
import com.pojo.User;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    HttpSession httpSession;
    @Override
    public List<Message> getAllMessage(Integer begin,Integer num) {
        return messageMapper.findAll(begin,num);
    }

    @Override
    public Map<String,String> add(Message message) {
        Map<String,String> map = new HashMap<String, String>();
        User user = (User) httpSession.getAttribute("user");
        if (user==null){
            map.put("status","-1");
            map.put("msg","请登陆之后再留言");
        }else {
            message.setUid(user.getId());
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sf.format(date);
            message.setDate(format);
            int i = messageMapper.addMessage(message);


            if (i>0){
                map.put("status","200");
                map.put("msg","添加成功");
                map.put("username",user.getUsername());
                map.put("date",format);
            }else {
                map.put("status","0");
                map.put("msg","添加失败");
            }
        }
        return map;
    }

    @Override
    public int getCount() {
        return messageMapper.count();
    }

    @Override
    public int getCount(String start,String end, int did) {
        return messageMapper.count(start,end,did);
    }

    @Override
    public List<Message> message_list(String start, String end, int begin, int num,int did) {
        return messageMapper.getAllMessage(start,end,begin,num,did);
    }

    @Override
    public Map<String, String> message_del(int id) {
        int i = messageMapper.deleteMessage(id);
        Map<String,String> map = new HashMap<String, String>();
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
    public Map<String, String> message_dels(Integer[] ids) {
        int i = messageMapper.deleteMessages(ids);
        Map<String,String> map = new HashMap<String, String>();
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

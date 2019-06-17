package com.service;

import com.pojo.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {
    /**
     * 获取所有的留言
     * @return
     */
    List<Message> getAllMessage(Integer begin,Integer num);

    /**
     * 新增留言
     * @param message
     * @return
     */
    Map<String,String> add(Message message);

    /**
     * 获取留言总数
     * @return
     */
    int getCount();
}

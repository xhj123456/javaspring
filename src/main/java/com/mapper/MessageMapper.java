package com.mapper;

import com.pojo.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageMapper {
    List<Message> findAll(Integer begin,Integer num);
    int addMessage(Message message);
    int count();
    int count(String start,String end,int did);
    /**
     * 获取文章列表
     * @param start 开始时间
     * @param end 结束时间
     * @param begin 开始条数
     * @param num 每页条数
     * @param did 文章id
     * @return
     */
    List<Message> getAllMessage(String start,String end,int begin,int num,int did);
    /**
     * 删除一篇文章
     * @param id 文章id
     * @return
     */
    int deleteMessage(int id);
    int deleteMessages(Integer[] ids);
}

package com.mapper;

import com.pojo.Photos;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotosMapper {
    /**
     * 添加照片
     * @param photos
     * @return
     */
     int insertPhotos(Photos photos);
    /**
     * 获取文章列表
     * @param title 标题
     * @param start 开始时间
     * @param end 结束时间
     * @param begin 开始条数
     * @param num 每页条数
     * @param cid 分类id
     * @return
     */
     List<Photos> selectAll(String title, String start, String end,int begin,int num,int cid);
    /**
     * 获取文章总数量
     * @param title 标题
     * @param start 开始时间
     * @param end 结束时间
     * @param cid 分类id
     * @return
     */
    int getCount(String title,String start,String end,int cid);
}

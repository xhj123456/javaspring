package com.mapper;

import com.pojo.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentMapper {
    /**
     * 新增文章
     * @param document
     * @return
     */
    int addDocument(Document document);
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
    List<Document> getAllDocument(String title,String start,String end,int begin,int num,int cid);

    /**
     * 获取文章总数量
     * @param title 标题
     * @param start 开始时间
     * @param end 结束时间
     * @param cid 分类id
     * @return
     */
    int getCount(String title,String start,String end,int cid);

    /**
     * 获取文章详情
     * @param id
     * @return
     */
    Document getDocumentById(int id);

    /**
     * 获取上一章
     * @param id
     * @return
     */
    Document getPrevDocumentById(int id);

    /**
     * 获取下一章
     * @param id
     * @return
     */
    Document getNextDocumentById(int id);
    /**
     * 修改文章
     * @param document
     * @return
     */
    int updateDocumentById(Document document);

    /**
     * 删除一篇文章
     * @param ids 文章id
     * @return
     */
    int deleteDocument(String ids);

    /**
     * 批量删除文章
     * @param ids
     * @return
     */
    int deleteDocuments(Integer[] ids);
}

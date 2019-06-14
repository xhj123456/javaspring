package com.mapper;

import com.pojo.Document;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentMapper {
    int addDocument(Document document);
}

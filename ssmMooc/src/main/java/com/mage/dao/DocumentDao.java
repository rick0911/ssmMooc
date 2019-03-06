package com.mage.dao;

import com.mage.domain.Document;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DocumentDao {

    @Select({"select d.id,d.name,d.kind,d.uploadUser,u.username,u.nickname,u.usertype,c.bigname,c.smallname from document d,userinfo u,classify c where d.uploadUser = u.username and d.kind = c.id"})
    @ResultMap("documentPro")
    public List<Document> selectAllDocument() throws Exception;

    @Delete({"delete from document where id = #{id}"})
    public void deleteDocumentById(Integer id) throws Exception;
}

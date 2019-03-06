package com.mage.mapper;

import com.mage.domain.Classify;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassIfyDao {
    public List<Classify>  selectAllClassify() throws Exception;

    @Select("select id from classify where bigName = #{bigName} and smallName = #{smallName}")
    public Integer  selectClassifyByKind(Classify classify) throws Exception;
}

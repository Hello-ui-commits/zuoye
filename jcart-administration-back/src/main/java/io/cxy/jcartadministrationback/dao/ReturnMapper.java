package io.cxy.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import io.cxy.jcartadministrationback.dto.in.ReturnSearchInDTO;
import io.cxy.jcartadministrationback.po.Return;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

//    custom

    Page<Return> search(@Param("customerId") Integer customerId, ReturnSearchInDTO returnSearchInDTO);

}
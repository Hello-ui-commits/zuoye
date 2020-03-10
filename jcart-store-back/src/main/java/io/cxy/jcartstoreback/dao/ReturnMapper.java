package io.cxy.jcartstoreback.dao;

import com.github.pagehelper.Page;
import io.cxy.jcartstoreback.po.Return;

public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    Page<Return> selectPageByCustomerId(Integer customerId);
}
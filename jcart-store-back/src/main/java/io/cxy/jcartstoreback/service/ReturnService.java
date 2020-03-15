package io.cxy.jcartstoreback.service;

import com.github.pagehelper.Page;
import io.cxy.jcartstoreback.po.Return;

public interface ReturnService {

    Integer create(Return aReturn);

    Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum);

    Return getById(Integer returnId);

}

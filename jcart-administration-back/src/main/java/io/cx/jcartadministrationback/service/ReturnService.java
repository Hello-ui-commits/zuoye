package io.cx.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.cx.jcartadministrationback.po.Return;

public interface ReturnService {

    Page<Return> search(Integer pageNum);

    Return getById(Integer returnId);

    void update(Return aReturn);

}

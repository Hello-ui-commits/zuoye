package io.cxy.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.cxy.jcartadministrationback.dao.ReturnMapper;
import io.cxy.jcartadministrationback.dto.in.ReturnSearchInDTO;
import io.cxy.jcartadministrationback.po.Return;
import io.cxy.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Page<Return> search(ReturnSearchInDTO returnSearchInDTO, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<Return> page = returnMapper.search(
                returnSearchInDTO.getReturnId(),
                returnSearchInDTO.getCustomerName(),
                returnSearchInDTO.getOrderId(),
                returnSearchInDTO.getProductCode(),
                returnSearchInDTO.getProductName(),
                returnSearchInDTO.getStatus()
        );
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = returnMapper.selectByPrimaryKey(returnId);
        return aReturn;
    }

    @Override
    public void update(Return aReturn) {
        returnMapper.updateByPrimaryKeySelective(aReturn);
    }
}

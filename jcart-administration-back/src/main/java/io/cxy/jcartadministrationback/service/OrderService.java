package io.cxy.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.cxy.jcartadministrationback.dto.in.OrderSearchInDTO;
import io.cxy.jcartadministrationback.dto.out.OrderListOutDTO;
import io.cxy.jcartadministrationback.dto.out.OrderShowOutDTO;
import io.cxy.jcartadministrationback.po.Order;

public interface OrderService {

    Page<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO, Integer pageNum);

    OrderShowOutDTO getById(Long orderId);

    void update(Order order);

}

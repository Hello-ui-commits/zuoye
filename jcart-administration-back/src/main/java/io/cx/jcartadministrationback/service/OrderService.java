package io.cx.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.cx.jcartadministrationback.dto.out.OrderListOutDTO;
import io.cx.jcartadministrationback.dto.out.OrderShowOutDTO;
import io.cx.jcartadministrationback.po.Order;

public interface OrderService {

    Page<OrderListOutDTO> search(Integer pageNum);

    OrderShowOutDTO getById(Long orderId);

    void update(Order order);

}

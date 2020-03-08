package io.cxy.jcartstoreback.service;

import io.cxy.jcartstoreback.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    List<OrderHistory> getByOrderId(Long orderId);
}

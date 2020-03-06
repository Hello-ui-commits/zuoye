package io.cxy.jcartstoreback.service;

import io.cxy.jcartstoreback.dto.in.OrderCheckoutInDTO;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                      Integer customerId);


}

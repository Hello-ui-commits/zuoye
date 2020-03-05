package io.cxy.jcartstoreback.service.impl;

import io.cxy.jcartstoreback.dao.OrderDetailMapper;
import io.cxy.jcartstoreback.dao.OrderMapper;
import io.cxy.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.cxy.jcartstoreback.dto.in.OrderProductInDTO;
import io.cxy.jcartstoreback.dto.out.ProductShowOutDTO;
import io.cxy.jcartstoreback.enumeration.OrderStatus;
import io.cxy.jcartstoreback.po.Order;
import io.cxy.jcartstoreback.service.OrderService;
import io.cxy.jcartstoreback.service.ProductService;
import io.cxy.jcartstoreback.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private ProductService productService;

    @Override
    public Integer checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                            Integer customerId) {
        List<OrderProductInDTO> orderProductInDTOS = orderCheckoutInDTO.getOrderProducts();
        List<OrderProductVO> productVOS = orderProductInDTOS.stream().map(orderProductInDTO -> {
            ProductShowOutDTO orderProduct = productService.getById(orderProductInDTO.getProductId());
            OrderProductVO orderProductVO = new OrderProductVO();
            orderProductVO.setProductId(orderProductInDTO.getProductId());
            //单求数量
            Integer quantity = orderProductInDTO.getQuantity();
            orderProductVO.setQuantity(quantity);
            Double price = orderProduct.getPrice() * orderProduct.getDiscount();
            orderProductVO.setUnitPrice(price);
            //总价格
            Double totalPrice = price * orderProductInDTO.getQuantity();
            orderProductVO.setProductTotal(totalPrice);
            //单求积分
            Integer rewordPoints = orderProduct.getRewordPoints();
            orderProductVO.setUnitRewordPoints(rewordPoints);
            //求出总积分
            Integer totalRwordPoints =rewordPoints *quantity;
            orderProductVO.setTotalRewordPoints(totalRwordPoints);
            return orderProductVO;
        }).collect(Collectors.toList());
        //求所有和
        double AllTotalPrice = productVOS.stream().mapToDouble(p -> p.getProductTotal()).sum();
        //求所有积分
        int totalRewordPoints = productVOS.stream().mapToInt(p -> p.getTotalRewordPoints()).sum();


        Order order = new Order();
        order.setCustomerId(customerId);
        order.setStatus((byte) OrderStatus.Toprocess.ordinal());
        order.setTotalPrice(AllTotalPrice);
        order.setRewordPoints(totalRewordPoints);
        Date date = new Date();
        order.setCreateTime(date);
        order.setUpdateTime(date);
        return null;
    }
}

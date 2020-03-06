package io.cxy.jcartstoreback.service.impl;

import com.alibaba.fastjson.JSON;
import io.cxy.jcartstoreback.dao.OrderDetailMapper;
import io.cxy.jcartstoreback.dao.OrderMapper;
import io.cxy.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.cxy.jcartstoreback.dto.in.OrderProductInDTO;
import io.cxy.jcartstoreback.dto.out.ProductShowOutDTO;
import io.cxy.jcartstoreback.enumeration.OrderStatus;
import io.cxy.jcartstoreback.po.Address;
import io.cxy.jcartstoreback.po.Order;
import io.cxy.jcartstoreback.po.OrderDetail;
import io.cxy.jcartstoreback.po.Product;
import io.cxy.jcartstoreback.service.AddressService;
import io.cxy.jcartstoreback.service.OrderService;
import io.cxy.jcartstoreback.service.ProductService;
import io.cxy.jcartstoreback.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private AddressService addressService;

    @Override
    @Transactional
    public Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                            Integer customerId) {
        List<OrderProductInDTO> orderProductInDTOS = orderCheckoutInDTO.getOrderProducts();
        List<OrderProductVO> productVOS = orderProductInDTOS.stream().map(orderProductInDTO -> {
            Product orderProduct = productService.getById(orderProductInDTO.getProductId());
            OrderProductVO orderProductVO = new OrderProductVO();
            orderProductVO.setProductId(orderProduct.getProductId());
            orderProductVO.setProductCode(orderProduct.getProductCode());
            orderProductVO.setProductName(orderProduct.getProductName());
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
            Integer totalRwordPoints = rewordPoints * quantity;
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
        orderMapper.insertSelective(order);
        Long orderId = order.getOrderId();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setShipMethod(orderCheckoutInDTO.getShipMethod());
        //todo caiculate ship price with ship method
        orderDetail.setShipPrice(5.0);
        Address address = addressService.getById(orderCheckoutInDTO.getShipAddressId());
        orderDetail.setShipAddress(address.getContent());
        orderDetail.setPayMethod(orderCheckoutInDTO.getPayMethod());
        orderDetail.setInvoicePrice(AllTotalPrice);
        Address invoiceAddress = addressService.getById(orderCheckoutInDTO.getInvoiceAddressId());
        orderDetail.setInvoiceAddress(invoiceAddress.getContent());
        orderDetail.setComment(orderCheckoutInDTO.getComment());
        orderDetail.setOrderProducts(JSON.toJSONString(productVOS));

        orderDetailMapper.insertSelective(orderDetail);
        return orderId;
    }
}

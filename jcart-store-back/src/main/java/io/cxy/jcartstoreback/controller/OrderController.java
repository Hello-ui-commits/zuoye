package io.cxy.jcartstoreback.controller;

import io.cxy.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.cxy.jcartstoreback.dto.out.OrderListOutDTO;
import io.cxy.jcartstoreback.dto.out.OrderShowOutDTO;
import io.cxy.jcartstoreback.dto.out.PageOutDTO;
import io.cxy.jcartstoreback.dto.out.ProductShowOutDTO;
import io.cxy.jcartstoreback.po.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @PostMapping("/checkout")
    public Long checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                         @RequestAttribute Integer customerId) {

        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestAttribute Integer customerId) {
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId) {
        return null;
    }
}

package io.cxy.jcartadministrationback.controller;

import io.cxy.jcartadministrationback.dto.in.OrderSearchInDTO;
import io.cxy.jcartadministrationback.dto.out.OrderListOutDTO;
import io.cxy.jcartadministrationback.dto.out.OrderShowOutDTO;
import io.cxy.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrdersController {
    @GetMapping("/list")
    public PageOutDTO<OrderListOutDTO> List(@RequestBody OrderSearchInDTO orderListInDTO){

        return  null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Integer OrderId){
        return null;
    }
}

package io.cxy.jcartadministrationback.controller;

import io.cxy.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;
import io.cxy.jcartadministrationback.dto.out.OrderHistoryListOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderHistory")
public class OrderHistoryController {
    @GetMapping("/list")
    public OrderHistoryListOutDTO list(){
        return null;
    }

    @PostMapping("/create")
    public void create(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){

    }
    @PostMapping("/delete")
    public void delete(@RequestParam Integer orderHistoryId){

    }
    @PostMapping("/deletes")
    public void deletes(@RequestParam Integer[] orderHistoryIds){

    }
}

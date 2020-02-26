package io.cxy.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import io.cxy.jcartadministrationback.dto.in.CustomerSearchInDTO;
import io.cxy.jcartadministrationback.dto.out.CustomerShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerControlelr {
    @GetMapping("/list")
    public Page<CustomerShowOutDTO> Lsit(@RequestBody CustomerSearchInDTO customerListInDTO){
        return null;
    }
    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        return null;
    }
}

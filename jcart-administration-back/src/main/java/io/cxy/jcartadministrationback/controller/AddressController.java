package io.cxy.jcartadministrationback.controller;

import io.cxy.jcartadministrationback.dto.out.AddressListOutDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    @PostMapping("/create")
    public void address(@RequestBody AddressListOutDTO addressCreateCreateInDTO){

    }
}

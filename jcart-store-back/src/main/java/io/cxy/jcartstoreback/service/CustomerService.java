package io.cxy.jcartstoreback.service;

import io.cxy.jcartstoreback.dto.in.CustomerRegisterInDTO;
import io.cxy.jcartstoreback.po.Customer;

public interface CustomerService {

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    Customer getByEmail(String email);

    void update(Customer customer);

}

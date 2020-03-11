package io.cxy.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.cxy.jcartadministrationback.dto.in.CustomerSearchInDTO;
import io.cxy.jcartadministrationback.dto.in.CustomerSetStatusInDTO;
import io.cxy.jcartadministrationback.po.Customer;

public interface CustomerService {

    Page<Customer> search(CustomerSearchInDTO customerSearchInDTO ,Integer pageNum);

    Customer getById(Integer customerId);

    void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);

}

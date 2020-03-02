package io.cxy.jcartstoreback.service;


import com.github.pagehelper.Page;
import io.cxy.jcartstoreback.dto.out.ProductListOutDTO;
import io.cxy.jcartstoreback.dto.out.ProductShowOutDTO;

public interface ProductService {

    ProductShowOutDTO getById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);

}

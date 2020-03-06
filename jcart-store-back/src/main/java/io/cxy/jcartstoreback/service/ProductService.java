package io.cxy.jcartstoreback.service;


import com.github.pagehelper.Page;
import io.cxy.jcartstoreback.dto.out.ProductListOutDTO;
import io.cxy.jcartstoreback.dto.out.ProductShowOutDTO;
import io.cxy.jcartstoreback.po.Product;

public interface ProductService {

    Product getById(Integer productId);

    ProductShowOutDTO getShowById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);

}

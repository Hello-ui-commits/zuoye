package io.cxy.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import io.cxy.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.cxy.jcartadministrationback.dto.in.ProductSearchInDTO;
import io.cxy.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.cxy.jcartadministrationback.dto.out.PageOutDTO;
import io.cxy.jcartadministrationback.dto.out.ProductListOutDTO;
import io.cxy.jcartadministrationback.dto.out.ProductShowOutDTO;
import io.cxy.jcartadministrationback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public PageOutDTO<ProductListOutDTO> list(@RequestBody ProductSearchInDTO productListInDTO,
                                              @RequestParam(defaultValue = "1") Integer pageNum) {
        Page<ProductListOutDTO> page = productService.search(pageNum);
        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);
        return pageOutDTO;
    }

    @PostMapping("/create")
    public Integer createProduct(@RequestBody ProductCreateInDTO productCreateInDTO) {
        return productService.create(productCreateInDTO);
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId) {
        return productService.getById(productId);
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO) {
        productService.update(productUpdateInDTO);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam Integer productId) {
        productService.delete(productId);
    }

    @PostMapping("/deletes")
    public void deletes(@RequestParam List<Integer> productId) {
        productService.deletes(productId);

    }
}

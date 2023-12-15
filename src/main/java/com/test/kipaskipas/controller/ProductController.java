package com.test.kipaskipas.controller;

import com.test.kipaskipas.dto.ProductDto;
import com.test.kipaskipas.dto.ResponseBase;
import com.test.kipaskipas.dto.request.ProductInsertRequestDto;
import com.test.kipaskipas.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseBase<ProductDto> getById(@PathVariable String id){
        return productService.getByProductId(id);
    }

    @PutMapping()
    public ResponseBase<ProductDto> editProduct(@RequestBody ProductDto productDto){
        return productService.editProduct(productDto);
    }

    @PostMapping
    public ResponseBase<String> addProduct(@RequestBody ProductInsertRequestDto productDto){
        return productService.addProduct(productDto);
    }
}

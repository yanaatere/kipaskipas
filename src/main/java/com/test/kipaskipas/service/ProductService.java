package com.test.kipaskipas.service;

import com.test.kipaskipas.customexception.CustomProductException;
import com.test.kipaskipas.dto.ProductDto;
import com.test.kipaskipas.dto.ResponseBase;
import com.test.kipaskipas.dto.request.ProductInsertRequestDto;
import com.test.kipaskipas.entity.Product;
import com.test.kipaskipas.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseBase<ProductDto> getByProductId(String productId) {
        try {
            Optional<Product> optionalProduct = productRepository.findByProductId(productId);
            if (optionalProduct.isPresent()) {
                ProductDto productDto = modelMapper.map(optionalProduct.get(), ProductDto.class);
                return new ResponseBase<>(HttpStatus.OK, "Success Get Data By Id", productDto);
            } else {
                return new ResponseBase<>(HttpStatus.NO_CONTENT, "Can't Find Data By Id", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBase<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }

    public ResponseBase<ProductDto> editProduct(ProductDto editProduct) {
        try {
            Optional<Product> optionalProduct = productRepository.findByProductId(editProduct.getProductId());
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                product.setProductPrice(editProduct.getProductPrice());
                product.setProductDescription(editProduct.getProductDescription());
                product.setStock(editProduct.getStock());
                productRepository.save(product);
                return new ResponseBase<>(HttpStatus.OK, "Success Edit Product", editProduct);
            } else {
                return new ResponseBase<>(HttpStatus.NO_CONTENT, "Failed Edit Product Because Product Not Found", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBase<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }

    public ResponseBase<String> addProduct(ProductInsertRequestDto addProduct) {
        try {
            Product product = modelMapper.map(addProduct, Product.class);
            productRepository.save(product);
            return new ResponseBase<>(HttpStatus.OK, "Success Save New Product", product.getProductId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBase<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }

    public String minusStockProduct(String productId, int quantity) throws CustomProductException {
        Optional<Product> optionalProduct = productRepository.findByProductId(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            if(product.getStock() == 0){
                throw new CustomProductException("Product Is Empty, Please Change Your Request");
            }

            int stock = product.getStock() - quantity;
            if(stock < 0){
                throw new CustomProductException("Quantity you requested exceeds our current stock availability, Please change your quantity");
            }

            product.setStock(stock);
            productRepository.save(product);
            return productId;
        } else throw new CustomProductException("Product Not Found, Please check your ProductId");
    }
}

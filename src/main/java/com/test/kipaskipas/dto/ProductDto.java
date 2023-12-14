package com.test.kipaskipas.dto;

import com.test.kipaskipas.entity.Product;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Product}
 */
public class ProductDto implements Serializable {
    private String productId;
    private String productPrice;
    private String productDescription;
    private Integer stock;

    public ProductDto() {
    }

    public ProductDto(String productId, String productPrice, String productDescription, Integer stock) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "productid = " + productId + ", " +
                "productprice = " + productPrice + ", " +
                "productdescription = " + productDescription + ", " +
                "stock = " + stock + ")";
    }
}
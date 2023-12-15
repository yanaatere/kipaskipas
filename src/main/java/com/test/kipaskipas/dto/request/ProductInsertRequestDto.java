package com.test.kipaskipas.dto.request;

import java.io.Serializable;


public class ProductInsertRequestDto implements Serializable {
    private String productPrice;
    private String productDescription;
    private Integer stock;

    public ProductInsertRequestDto() {
    }

    public ProductInsertRequestDto(String productPrice, String productDescription, Integer stock) {
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.stock = stock;
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
                "productprice = " + productPrice + ", " +
                "productdescription = " + productDescription + ", " +
                "stock = " + stock + ")";
    }
}
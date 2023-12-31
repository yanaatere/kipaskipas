package com.test.kipaskipas.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product", schema = "public")
public class Product implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "productid", nullable = false)
    private String productId;

    @Column(name = "productprice")
    private String productPrice;

    @Column(name = "productdescription")
    private String productDescription;

    @Column(name = "stock")
    private Integer stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    public Product() {
    }

    public Product(String productId, String productPrice, String productDescription, Integer stock) {
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
}
package com.test.kipaskipas.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "orderid", nullable = false)
    private String orderid;

    @Column(name = "customerid")
    private String customerid;

    @Column(name = "customername")
    private String customername;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "productid")
    private String productid;

    @Column(name = "orderdata")
    private Instant orderdata;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {

    }

    public Order(String orderid, String customerid, String customername, BigDecimal amount, Integer quantity, String productid, Instant orderdata, Customer customer) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.customername = customername;
        this.amount = amount;
        this.quantity = quantity;
        this.productid = productid;
        this.orderdata = orderdata;
        this.customer = customer;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public Instant getOrderdata() {
        return orderdata;
    }

    public void setOrderdata(Instant orderdata) {
        this.orderdata = orderdata;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
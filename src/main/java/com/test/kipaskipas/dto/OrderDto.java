package com.test.kipaskipas.dto;

import com.test.kipaskipas.entity.Order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link Order}
 */
public class OrderDto implements Serializable {
    private String orderId;
    private String customerId;
    private String customerName;
    private BigDecimal amount;
    private Integer quantity;
    private String productId;
    private Instant orderDate;
    private CustomerDto customer;
    private List<ProductDto> products;

    public OrderDto() {
    }

    public OrderDto(String orderId, String customerId, String customerName, BigDecimal amount,
                    Integer quantity, String productId, Instant orderDate, CustomerDto customer,
                    List<ProductDto> products) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.amount = amount;
        this.quantity = quantity;
        this.productId = productId;
        this.orderDate = orderDate;
        this.customer = customer;
        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto entity = (OrderDto) o;
        return Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.customerId, entity.customerId) &&
                Objects.equals(this.customerName, entity.customerName) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.orderDate, entity.orderDate) &&
                Objects.equals(this.customer, entity.customer) &&
                Objects.equals(this.products, entity.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, customerName, amount, quantity, productId, orderDate, customer, products);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "orderid = " + orderId + ", " +
                "customerid = " + customerId + ", " +
                "customername = " + customerName + ", " +
                "amount = " + amount + ", " +
                "quantity = " + quantity + ", " +
                "productid = " + productId + ", " +
                "orderdata = " + orderDate + ", " +
                "customer = " + customer + ", " +
                "products = " + products + ")";
    }
}
package com.test.kipaskipas.dto;

import com.test.kipaskipas.entity.Customer;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Customer}
 */
public class CustomerDto implements Serializable {
    private String customerId;
    private String customerName;
    private String address;
    private Integer phone;

    public CustomerDto() {
    }

    public CustomerDto(String customerId, String customerName, String address, Integer phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
package com.test.kipaskipas.dto.request;

import java.io.Serializable;

public class CustomerInsertRequestDto implements Serializable {
    private String customerName;
    private String address;
    private Integer phone;

    public CustomerInsertRequestDto() {
    }

    public CustomerInsertRequestDto(String customerName, String address, Integer phone) {
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
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
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
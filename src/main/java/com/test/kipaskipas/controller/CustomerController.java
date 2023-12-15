package com.test.kipaskipas.controller;

import com.test.kipaskipas.dto.CustomerDto;
import com.test.kipaskipas.dto.ResponseBase;
import com.test.kipaskipas.dto.request.CustomerInsertRequestDto;
import com.test.kipaskipas.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseBase<CustomerDto> getById(@PathVariable String id){
        return customerService.getByCustomerId(id);
    }

    @PutMapping()
    public ResponseBase<CustomerDto> editCustomer(@RequestBody CustomerDto customerDto){
        return customerService.editProduct(customerDto);
    }

    @PostMapping
    public ResponseBase<String> addProduct(@RequestBody CustomerInsertRequestDto customerDto){
        return customerService.addCustomer(customerDto);
    }

}

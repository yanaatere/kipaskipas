package com.test.kipaskipas.service;

import com.test.kipaskipas.dto.CustomerDto;
import com.test.kipaskipas.dto.ResponseBase;
import com.test.kipaskipas.dto.request.CustomerInsertRequestDto;
import com.test.kipaskipas.entity.Customer;
import com.test.kipaskipas.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseBase<CustomerDto> getByCustomerId(String id) {
        try{
            Optional<Customer> optionalCustomer = customerRepository.findByCustomerId(id);
            if(optionalCustomer.isPresent()) {
                CustomerDto customerDto = modelMapper.map(optionalCustomer.get(), CustomerDto.class);
                return new ResponseBase<>(HttpStatus.OK, "Success Get Data By Id", customerDto);
            } else {
                return new ResponseBase<>(HttpStatus.NO_CONTENT, "Can't Find Data By Id", null);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseBase<>(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(), null);
        }
    }

    public ResponseBase<CustomerDto> editProduct(CustomerDto editCustomer) {
        try {
            Optional<Customer> optionalCustomer = customerRepository.findByCustomerId(editCustomer.getCustomerId());
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                customer.setCustomerName(editCustomer.getCustomerName());
                customer.setAddress(editCustomer.getAddress());
                customer.setPhone(editCustomer.getPhone());
                customerRepository.save(customer);
                return new ResponseBase<>(HttpStatus.OK, "Success Edit Customer", editCustomer);
            } else {
                return new ResponseBase<>(HttpStatus.NO_CONTENT, "Failed Edit Customer Because Customer Not Found", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBase<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }

    public ResponseBase<String> addCustomer(CustomerInsertRequestDto addCustomer) {
        try {
            Customer customer = modelMapper.map(addCustomer, Customer.class);
            customerRepository.save(customer);
            return new ResponseBase<>(HttpStatus.OK, "Success Save New Customer", customer.getCustomerId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBase<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }
}

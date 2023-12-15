package com.test.kipaskipas.service;

import com.test.kipaskipas.customexception.CustomProductException;
import com.test.kipaskipas.dto.CustomerDto;
import com.test.kipaskipas.dto.request.CreateOrderRequestDto;
import com.test.kipaskipas.dto.ResponseBase;
import com.test.kipaskipas.entity.Order;
import com.test.kipaskipas.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, CustomerService customerService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
    }

    @Transactional
    public ResponseBase createOrderRequest(CreateOrderRequestDto createOrderRequestDto) {
        Order order = new Order();
        order.setAmount(createOrderRequestDto.getAmount());
        order.setOrderDate(new Date().toInstant());
        ResponseBase<CustomerDto> byCustomerId = customerService.getByCustomerId(createOrderRequestDto.getCustomerId());

        if (byCustomerId.getStatus().equals(HttpStatus.OK)) {
            CustomerDto data = byCustomerId.getData();
            order.setCustomerId(data.getCustomerId());
            order.setCustomerName(data.getCustomerName());
        } else return new ResponseBase<>(HttpStatus.BAD_REQUEST, "Invalid CustomerId Please Check The Request", null);

        try {
            String productId = productService.minusStockProduct(createOrderRequestDto.getProductId(), createOrderRequestDto.getQuantity());
            order.setProductId(productId);
        } catch (CustomProductException e) {
            return new ResponseBase<>(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }

        order.setQuantity(createOrderRequestDto.getQuantity());
        orderRepository.save(order);
        return new ResponseBase<>(HttpStatus.OK, "Success Create New Order ", order.getOrderId());
    }
}

package com.test.kipaskipas.controller;

import com.test.kipaskipas.dto.request.CreateOrderRequestDto;
import com.test.kipaskipas.dto.ResponseBase;
import com.test.kipaskipas.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseBase createOrderRequest(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
          return orderService.createOrderRequest(createOrderRequestDto);
    }
}

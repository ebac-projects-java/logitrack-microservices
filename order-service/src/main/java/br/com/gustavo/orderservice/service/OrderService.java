package br.com.gustavo.orderservice.service;

import br.com.gustavo.orderservice.dto.request.CreateOrderRequest;
import br.com.gustavo.orderservice.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse create(CreateOrderRequest request);

    List<OrderResponse> findAll();

    OrderResponse findById(Long id);

}
package br.com.gustavo.orderservice.service.impl;

import br.com.gustavo.orderservice.dto.request.CreateOrderRequest;
import br.com.gustavo.orderservice.dto.response.OrderResponse;
import br.com.gustavo.orderservice.entity.Order;
import br.com.gustavo.orderservice.model.OrderEvent;
import br.com.gustavo.orderservice.producer.OrderProducer;
import br.com.gustavo.orderservice.repository.OrderRepository;
import br.com.gustavo.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderProducer producer;

    @Override
    public OrderResponse create(CreateOrderRequest request) {

        Order order = Order.builder()
                .userId(request.getUserId())
                .produto(request.getProduto())
                .quantidade(request.getQuantidade())
                .valor(request.getValor())
                .status("CRIADO")
                .build();

        order = repository.save(order);

        OrderEvent event = OrderEvent.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .produto(order.getProduto())
                .quantidade(order.getQuantidade())
                .valor(order.getValor())
                .status(order.getStatus())
                .build();

        producer.send(event);

        return toResponse(order);
    }

    @Override
    public List<OrderResponse> findAll(){

        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();

    }

    @Override
    public OrderResponse findById(Long id){

        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow();

    }

    private OrderResponse toResponse(Order order){

        return OrderResponse.builder()

                .id(order.getId())
                .userId(order.getUserId())
                .produto(order.getProduto())
                .quantidade(order.getQuantidade())
                .valor(order.getValor())
                .status(order.getStatus())
                .build();

    }

}
package br.com.gustavo.orderservice.controller;

import br.com.gustavo.orderservice.dto.request.CreateOrderRequest;
import br.com.gustavo.orderservice.dto.response.OrderResponse;
import br.com.gustavo.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody CreateOrderRequest request){

        return ResponseEntity.ok(service.create(request));

    }

    @GetMapping
    public List<OrderResponse> findAll(){

        return service.findAll();

    }

    @GetMapping("/{id}")
    public OrderResponse findById(@PathVariable Long id){

        return service.findById(id);

    }

}
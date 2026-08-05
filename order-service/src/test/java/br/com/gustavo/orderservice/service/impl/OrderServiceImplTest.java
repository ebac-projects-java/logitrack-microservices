package br.com.gustavo.orderservice.service.impl;

import br.com.gustavo.orderservice.dto.request.CreateOrderRequest;
import br.com.gustavo.orderservice.dto.response.OrderResponse;
import br.com.gustavo.orderservice.entity.Order;
import br.com.gustavo.orderservice.producer.OrderProducer;
import br.com.gustavo.orderservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository repository;

    @Mock
    private OrderProducer producer;

    @InjectMocks
    private OrderServiceImpl service;

    @Test
    void deveCriarPedidoComSucesso() {

        CreateOrderRequest request = new CreateOrderRequest();

        request.setUserId(1L);
        request.setProduto("Notebook Dell Inspiron");
        request.setQuantidade(1);
        request.setValor(4599.90);

        Order order = Order.builder()
                .id(1L)
                .userId(1L)
                .produto("Notebook Dell Inspiron")
                .quantidade(1)
                .valor(4599.90)
                .status("CRIADO")
                .build();

        when(repository.save(any(Order.class))).thenReturn(order);

        OrderResponse response = service.create(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Notebook Dell Inspiron", response.getProduto());
        assertEquals("CRIADO", response.getStatus());

        verify(repository, times(1)).save(any(Order.class));

        verify(producer, times(1)).send(any());
    }

}
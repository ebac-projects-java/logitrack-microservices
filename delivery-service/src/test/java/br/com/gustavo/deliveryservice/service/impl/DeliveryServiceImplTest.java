package br.com.gustavo.deliveryservice.service.impl;

import br.com.gustavo.deliveryservice.dto.request.CreateDeliveryRequest;
import br.com.gustavo.deliveryservice.dto.response.DeliveryResponse;
import br.com.gustavo.deliveryservice.entity.Delivery;
import br.com.gustavo.deliveryservice.producer.DeliveryProducer;
import br.com.gustavo.deliveryservice.repository.DeliveryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeliveryServiceImplTest {

    @Mock
    private DeliveryRepository repository;

    @Mock
    private DeliveryProducer producer;

    @InjectMocks
    private DeliveryServiceImpl service;

    @Test
    void deveCriarEntregaComSucesso() {

        CreateDeliveryRequest request = CreateDeliveryRequest.builder()
                .orderId(1L)
                .destinatario("Cliente Teste")
                .endereco("Rua Teste, 123")
                .build();


        Delivery delivery = Delivery.builder()
                .id(1L)
                .orderId(1L)
                .destinatario("Cliente Teste")
                .endereco("Rua Teste, 123")
                .status("AGUARDANDO")
                .build();

        when(repository.save(any(Delivery.class))).thenReturn(delivery);

        DeliveryResponse response = service.create(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Cliente Teste", response.getDestinatario());
        assertEquals("AGUARDANDO", response.getStatus());

        verify(repository, times(1)).save(any(Delivery.class));

        verify(producer, times(1)).send(any());
    }

}
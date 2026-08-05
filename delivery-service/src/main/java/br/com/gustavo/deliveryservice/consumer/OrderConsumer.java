package br.com.gustavo.deliveryservice.consumer;

import br.com.gustavo.deliveryservice.dto.request.CreateDeliveryRequest;
import br.com.gustavo.deliveryservice.model.OrderEvent;
import br.com.gustavo.deliveryservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderConsumer {

    private final DeliveryService service;

    @KafkaListener(
            topics = "orders-topic",
            groupId = "delivery-group"
    )
    public void consume(OrderEvent event) {

        log.info("========== NOVO PEDIDO ==========");
        log.info("Pedido: {}", event.getId());

        CreateDeliveryRequest request = CreateDeliveryRequest.builder()
                .orderId(event.getId())
                .destinatario("Cliente " + event.getUserId())
                .endereco("Endereço não informado")
                .build();

        service.create(request);

        log.info("Entrega criada automaticamente.");
    }
}
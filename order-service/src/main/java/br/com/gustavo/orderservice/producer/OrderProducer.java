package br.com.gustavo.orderservice.producer;

import br.com.gustavo.orderservice.model.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void send(OrderEvent event) {

        kafkaTemplate.send("orders-topic", event);

    }
}
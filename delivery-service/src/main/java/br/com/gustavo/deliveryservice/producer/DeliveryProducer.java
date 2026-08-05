package br.com.gustavo.deliveryservice.producer;

import br.com.gustavo.deliveryservice.model.DeliveryEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryProducer {

    private final KafkaTemplate<String, DeliveryEvent> kafkaTemplate;

    public void send(DeliveryEvent event){

        kafkaTemplate.send("delivery-topic", event);

    }

}
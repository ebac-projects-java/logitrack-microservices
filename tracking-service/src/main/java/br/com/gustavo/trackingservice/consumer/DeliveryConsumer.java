package br.com.gustavo.trackingservice.consumer;

import br.com.gustavo.trackingservice.entity.Tracking;
import br.com.gustavo.trackingservice.model.DeliveryEvent;
import br.com.gustavo.trackingservice.repository.TrackingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeliveryConsumer {

    private final TrackingRepository repository;

    @KafkaListener(
            topics = "delivery-topic",
            groupId = "tracking-group"
    )
    public void consume(DeliveryEvent event) {

        log.info("========== NOVA ENTREGA ==========");
        log.info("Pedido: {}", event.getOrderId());

        Tracking tracking = Tracking.builder()
                .orderId(event.getOrderId())
                .localizacao("Centro de Distribuição")
                .status("SEPARAÇÃO")
                .build();

        repository.save(tracking);

        log.info("Tracking criado automaticamente.");
    }
}
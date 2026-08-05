package br.com.gustavo.deliveryservice.service.impl;

import br.com.gustavo.deliveryservice.dto.request.CreateDeliveryRequest;
import br.com.gustavo.deliveryservice.dto.request.UpdateDeliveryRequest;
import br.com.gustavo.deliveryservice.dto.response.DeliveryResponse;
import br.com.gustavo.deliveryservice.entity.Delivery;
import br.com.gustavo.deliveryservice.model.DeliveryEvent;
import br.com.gustavo.deliveryservice.producer.DeliveryProducer;
import br.com.gustavo.deliveryservice.repository.DeliveryRepository;
import br.com.gustavo.deliveryservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository repository;

    private final DeliveryProducer producer;

    @Override
    public List<DeliveryResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public DeliveryResponse findById(Long id) {

        Delivery delivery = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada."));

        return toResponse(delivery);
    }

    @Override
    public DeliveryResponse create(CreateDeliveryRequest request) {

        Delivery delivery = Delivery.builder()
                .orderId(request.getOrderId())
                .destinatario(request.getDestinatario())
                .endereco(request.getEndereco())
                .status("AGUARDANDO")
                .build();

        delivery = repository.save(delivery);

        DeliveryEvent event = DeliveryEvent.builder()
                .id(delivery.getId())
                .orderId(delivery.getOrderId())
                .destinatario(delivery.getDestinatario())
                .endereco(delivery.getEndereco())
                .status(delivery.getStatus())
                .build();

        producer.send(event);

        return toResponse(delivery);
    }

    @Override
    public DeliveryResponse update(Long id, UpdateDeliveryRequest request) {

        Delivery delivery = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada."));

        delivery.setDestinatario(request.getDestinatario());
        delivery.setEndereco(request.getEndereco());
        delivery.setStatus(request.getStatus());

        delivery = repository.save(delivery);

        return toResponse(delivery);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private DeliveryResponse toResponse(Delivery delivery) {

        return DeliveryResponse.builder()
                .id(delivery.getId())
                .orderId(delivery.getOrderId())
                .destinatario(delivery.getDestinatario())
                .endereco(delivery.getEndereco())
                .status(delivery.getStatus())
                .build();
    }
}
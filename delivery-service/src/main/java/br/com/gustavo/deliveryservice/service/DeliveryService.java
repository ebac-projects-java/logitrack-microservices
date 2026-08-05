package br.com.gustavo.deliveryservice.service;

import br.com.gustavo.deliveryservice.dto.request.CreateDeliveryRequest;
import br.com.gustavo.deliveryservice.dto.request.UpdateDeliveryRequest;
import br.com.gustavo.deliveryservice.dto.response.DeliveryResponse;

import java.util.List;

public interface DeliveryService {

    DeliveryResponse create(CreateDeliveryRequest request);

    List<DeliveryResponse> findAll();

    DeliveryResponse findById(Long id);

    DeliveryResponse update(Long id, UpdateDeliveryRequest request);

    void delete(Long id);

}
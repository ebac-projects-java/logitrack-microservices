package br.com.gustavo.deliveryservice.controller;

import br.com.gustavo.deliveryservice.dto.request.UpdateDeliveryRequest;
import br.com.gustavo.deliveryservice.dto.response.DeliveryResponse;
import br.com.gustavo.deliveryservice.service.DeliveryService;
import br.com.gustavo.deliveryservice.dto.request.CreateDeliveryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService service;

    @GetMapping
    public List<DeliveryResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DeliveryResponse findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<DeliveryResponse> create(
            @RequestBody CreateDeliveryRequest request) {

        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateDeliveryRequest request){

        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
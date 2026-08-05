package br.com.gustavo.trackingservice.controller;

import br.com.gustavo.trackingservice.dto.request.UpdateTrackingRequest;
import br.com.gustavo.trackingservice.dto.response.TrackingResponse;
import br.com.gustavo.trackingservice.service.TrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracking")
@RequiredArgsConstructor
public class TrackingController {

    private final TrackingService service;

    @GetMapping
    public List<TrackingResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TrackingResponse findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<TrackingResponse> create(@RequestBody TrackingResponse request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrackingResponse> update(
            @PathVariable String id,
            @RequestBody UpdateTrackingRequest request) {

        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
package br.com.gustavo.trackingservice.service.impl;

import br.com.gustavo.trackingservice.dto.request.UpdateTrackingRequest;
import br.com.gustavo.trackingservice.dto.response.TrackingResponse;
import br.com.gustavo.trackingservice.entity.Tracking;
import br.com.gustavo.trackingservice.repository.TrackingRepository;
import br.com.gustavo.trackingservice.service.TrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackingServiceImpl implements TrackingService {

    private final TrackingRepository repository;

    @Override
    public List<TrackingResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public TrackingResponse findById(String id) {

        Tracking tracking = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado."));

        return toResponse(tracking);
    }

    @Override
    public TrackingResponse create(TrackingResponse request) {

        Tracking tracking = Tracking.builder()
                .orderId(request.getOrderId())
                .localizacao(request.getLocalizacao())
                .status(request.getStatus())
                .build();

        return toResponse(repository.save(tracking));
    }

    @Override
    public TrackingResponse update(String id, UpdateTrackingRequest request) {

        Tracking tracking = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado."));

        tracking.setLocalizacao(request.getLocalizacao());
        tracking.setStatus(request.getStatus());

        return toResponse(repository.save(tracking));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    private TrackingResponse toResponse(Tracking tracking) {

        return TrackingResponse.builder()
                .id(tracking.getId())
                .orderId(tracking.getOrderId())
                .localizacao(tracking.getLocalizacao())
                .status(tracking.getStatus())
                .build();
    }
}
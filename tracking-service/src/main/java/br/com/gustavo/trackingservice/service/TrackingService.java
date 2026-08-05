package br.com.gustavo.trackingservice.service;

import br.com.gustavo.trackingservice.dto.request.UpdateTrackingRequest;
import br.com.gustavo.trackingservice.dto.response.TrackingResponse;

import java.util.List;

public interface TrackingService {

    List<TrackingResponse> findAll();

    TrackingResponse findById(String id);

    TrackingResponse create(TrackingResponse request);

    TrackingResponse update(String id, UpdateTrackingRequest request);

    void delete(String id);
}
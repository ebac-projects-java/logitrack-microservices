package br.com.gustavo.trackingservice.service.impl;

import br.com.gustavo.trackingservice.dto.response.TrackingResponse;
import br.com.gustavo.trackingservice.entity.Tracking;
import br.com.gustavo.trackingservice.repository.TrackingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrackingServiceImplTest {

    @Mock
    private TrackingRepository repository;

    @InjectMocks
    private TrackingServiceImpl service;

    @Test
    void deveCriarTrackingComSucesso() {

        TrackingResponse request = TrackingResponse.builder()
                .orderId(1L)
                .localizacao("Centro de Distribuição")
                .status("SEPARAÇÃO")
                .build();

        Tracking tracking = Tracking.builder()
                .id("abc123")
                .orderId(1L)
                .localizacao("Centro de Distribuição")
                .status("SEPARAÇÃO")
                .build();

        when(repository.save(any(Tracking.class))).thenReturn(tracking);

        TrackingResponse response = service.create(request);

        assertNotNull(response);
        assertEquals("abc123", response.getId());
        assertEquals(1L, response.getOrderId());
        assertEquals("Centro de Distribuição", response.getLocalizacao());
        assertEquals("SEPARAÇÃO", response.getStatus());

        verify(repository, times(1)).save(any(Tracking.class));
    }

}
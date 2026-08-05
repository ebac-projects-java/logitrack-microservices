package br.com.gustavo.trackingservice.dto.request;

import lombok.Data;

@Data
public class UpdateTrackingRequest {

    private String localizacao;

    private String status;
}
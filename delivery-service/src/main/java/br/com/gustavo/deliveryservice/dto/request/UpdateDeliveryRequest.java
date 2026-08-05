package br.com.gustavo.deliveryservice.dto.request;

import lombok.Data;

@Data
public class UpdateDeliveryRequest {

    private String destinatario;
    private String endereco;
    private String status;
}
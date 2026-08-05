package br.com.gustavo.deliveryservice.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateDeliveryRequest {

    private Long orderId;

    private String destinatario;

    private String endereco;

}
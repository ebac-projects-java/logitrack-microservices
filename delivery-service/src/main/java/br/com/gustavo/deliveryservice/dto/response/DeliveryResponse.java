package br.com.gustavo.deliveryservice.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryResponse {

    private Long id;
    private Long orderId;
    private String destinatario;
    private String endereco;
    private String status;
}
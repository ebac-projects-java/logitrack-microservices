package br.com.gustavo.trackingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryEvent {

    private Long id;

    private Long orderId;

    private String destinatario;

    private String endereco;

    private String status;

}
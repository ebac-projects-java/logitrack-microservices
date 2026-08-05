package br.com.gustavo.deliveryservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {

    private Long id;

    private Long userId;

    private String produto;

    private Integer quantidade;

    private Double valor;

    private String status;
}
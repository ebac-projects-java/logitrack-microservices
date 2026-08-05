package br.com.gustavo.orderservice.model;

import lombok.*;

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
package br.com.gustavo.orderservice.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private Long id;

    private Long userId;

    private String produto;

    private Integer quantidade;

    private Double valor;

    private String status;

}
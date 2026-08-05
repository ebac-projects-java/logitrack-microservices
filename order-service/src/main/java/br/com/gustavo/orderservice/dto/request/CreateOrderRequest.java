package br.com.gustavo.orderservice.dto.request;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private Long userId;

    private String produto;

    private Integer quantidade;

    private Double valor;

}
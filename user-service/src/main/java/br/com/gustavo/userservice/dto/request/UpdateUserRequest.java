package br.com.gustavo.userservice.dto.request;

import lombok.Data;

@Data
public class UpdateUserRequest {

    private String nome;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;

}
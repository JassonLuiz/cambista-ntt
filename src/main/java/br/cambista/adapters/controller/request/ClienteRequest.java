package br.cambista.adapters.controller.request;

import lombok.Data;

@Data
public class ClienteRequest {

    private String nome;
    private String email;
    private String telefone;
}

package br.cambista.adapters.controller.request;

import lombok.Data;

@Data
public class EventoRequest {

    private String nome;
    private Long totalIngressos;
    private String usuarioCriacao;

}

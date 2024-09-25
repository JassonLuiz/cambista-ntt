package br.cambista.adapters.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoResponse {

    private Long idTeste;
    private String id;
    private String nome;
    private Long totalIngressos;
    private String usuarioCriacao;
    private LocalDateTime dataCriacao;

}

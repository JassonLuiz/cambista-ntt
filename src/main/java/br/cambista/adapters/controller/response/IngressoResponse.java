package br.cambista.adapters.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngressoResponse {
    private EventoResponse evento;
    private ClienteResponse cliente;
    private String status;
}

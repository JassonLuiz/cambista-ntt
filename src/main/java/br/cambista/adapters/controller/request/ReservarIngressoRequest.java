package br.cambista.adapters.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservarIngressoRequest {
    private Long idEvento;
    private Long idCliente;
    private Long quantidade;
}

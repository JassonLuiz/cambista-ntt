package br.cambista.domains.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservarIngresso {
    private Long idEvento;
    private Long idCliente;
    private Long quantidade;
}

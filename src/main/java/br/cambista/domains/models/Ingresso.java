package br.cambista.domains.models;

import br.cambista.adapters.state.DisponivelState;
import br.cambista.adapters.state.TicketState;
import br.cambista.domains.enumx.IngressoEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class Ingresso {

    private Long id;
    private Cliente cliente;
    private String nomeEvento;
    private LocalDateTime dataCompra;
    private IngressoEnum status;

    @Override
    public String toString() {
        return "Ingresso{id=" + id + ", cliente=" + (cliente != null ? cliente.getId() : "null") + "}";
    }
}

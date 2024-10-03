package br.cambista.adapters.integration.entity;

import br.cambista.adapters.state.DisponivelState;
import br.cambista.adapters.state.TicketState;
import br.cambista.domains.enumx.IngressoEnum;
import br.cambista.domains.models.Cliente;
import br.cambista.domains.models.Evento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class IngressoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private EventoEntity evento;

    private IngressoEnum status;

    private LocalDateTime dataCompra;

    @Override
    public String toString() {
        return "Ingresso{id=" + id + ", cliente=" + (cliente != null ? cliente.getId() : "null") + "}";
    }
}

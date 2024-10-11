package br.cambista.adapters.integration.entity;

import br.cambista.adapters.state.DisponivelState;
import br.cambista.adapters.state.TicketState;
import br.cambista.domains.enumx.IngressoEnum;
import br.cambista.domains.models.Cliente;
import br.cambista.domains.models.Evento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString(exclude = {"evento"})
@EqualsAndHashCode(exclude = {"evento"})
@Entity
@Table(name = "ingressos")
public class IngressoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    @JsonBackReference
    private EventoEntity evento;

    @Enumerated(EnumType.STRING)
    private IngressoEnum status;

    private LocalDateTime dataCompra;


}

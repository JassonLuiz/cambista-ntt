package br.cambista.domains.models;

import br.cambista.adapters.state.DisponivelState;
import br.cambista.adapters.state.TicketState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Transient
    private TicketState state;
    private LocalDateTime dataCompra;

    public Ingresso(Evento evento) {
        this.state = new DisponivelState();
        this.evento = evento;
    }

    public String reservar(Cliente cliente){
        this.cliente = cliente;
        return state.reservar(this);
    }

    public String pagar(){
        return state.pagar(this);
    }

    public String cancelar(){
        return state.cancelar(this);
    }

    public String expirar(){
        return state.expirar(this);
    }
}

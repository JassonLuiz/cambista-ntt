package br.cambista.adapters.state;

import br.cambista.domains.models.Ingresso;

public interface TicketState {

    String reservar(Ingresso ingresso);
    String pagar(Ingresso ingresso);
    String cancelar(Ingresso ingresso);
    String expirar(Ingresso ingresso);
}
